package com.cyzc.java.io.nio;

import com.cyzc.java.io.MyIOUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 不管是 NIO 还是 BIO  本质都是Socket编程，也就是说，Server端亘古不变的就是
 * <br>1. 创建Socket对象
 * <br>2. bind 绑定ip地址和端口
 * <br>3. listen 监听客户端链接事件
 * <br>4. accept client端 connect请求，开始tcp 三次握手四次挥手
 * <br>5. read client的write 事件
 * <br>6. write 响应给 client read.
 *
 * @author Cyzc
 * @since [2022/11/28 22:03]
 */
@Slf4j
public class NioServerDemo3 {

    private static final int PORT = 8888;
    private static final int BUFFER_SIZE = 1024;
    // 控制台输入流
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        new NioServerDemo3().initService();
    }

    private void initService() throws IOException {
        log.info("init server...");
        //1. 初始化 ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2. 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //3. bin ip/port
        serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), PORT));
        //4. init Selector
        Selector selector = Selector.open();
        //5. 注册事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            if (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //todo 有一些问题，为什么从客户端发送信息，还是会走accept事件，难道不会复用之前的链接吗？
                if (key.isValid() && key.isAcceptable()) {
                    accept(selector, key);
                } else if (key.isValid() && key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    String s = MyIOUtils.readDataFromSocketChannel(channel, BUFFER_SIZE);
                    log.info("读到客户端的数据"+s);
                } else if (key.isValid() && key.isWritable()) {
                    write(selector, key);
                }
            }

        }

    }

    /**
     * 对应server端的accept 事件,用来接收client端的 connect 事件， accept之后，就可以创建一个 socketChannel来绑定相关事件
     *
     * @param selector Selector
     * @param key      SelectionKey
     * @return {@link Void}
     * @author cyzc
     * @since 2022/11/29 9:23
     */
    private void accept(Selector selector, SelectionKey key) throws IOException {
        //1. accept 事件 获取 ServerSocketChannel
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        //2. 获取tcp 链接通道
        SocketChannel accept = serverSocketChannel.accept();
        //3. 将传输通道设置为非阻塞
        accept.configureBlocking(false);
        //4. 绑定读取事件，为什么要绑定读取事件呢？而不是绑定写入事件，
        //想一下，别的端发现该channel read的时候就会执行read操作吧？ 也就是说，我注册某事件，是想让另外一端来做这件事。
        accept.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);

        log.info("connect success with client from：" + accept.socket().getInetAddress()
                .getHostAddress());

    }

    /**
     * 将数据写回到 channel 里。
     *
     * @param selector
     * @param key
     * @return {@link Void}
     * @author cyzc
     * @since 2022/11/29 9:32
     */
    private void write(Selector selector, SelectionKey key) throws IOException {
        //1. 创建tcp 协议通信的 通道
        SocketChannel socketChannel = (SocketChannel) key.channel();
        //2. 分配Buffer
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        //3. 写数据前要清除一下缓冲区
        buffer.clear();
        //向 buffer中写数据
        buffer.put(ByteBuffer.wrap(scanner.nextLine().getBytes(StandardCharsets.UTF_8)));
        //切换为读模式，不让写数据了
        buffer.flip();
        //设置为非阻塞
        socketChannel.configureBlocking(false);
        //开始写数据
        while (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
        //继续注册为读事件，因为我channel中已经有数据了，就需要注册为读事件，供给别的端来读
        socketChannel.register(selector, SelectionKey.OP_READ);
    }
}
