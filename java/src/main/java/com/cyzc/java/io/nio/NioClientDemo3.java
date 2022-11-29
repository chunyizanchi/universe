package com.cyzc.java.io.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/28 22:01]
 */
@Slf4j
public class NioClientDemo3 {

    // 端口号
    private static final int PORT = 8888;
    // 缓存大小
    private static final int BUFFER_SIZE = 1024;
    // 控制台输入流
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        new NioClientDemo3().send();
    }

    public void send() throws IOException {

        log.info("init client ing...");
        //初始化客户端channel
        SocketChannel socketChannel = SocketChannel.open();
        //设置为非阻塞
        socketChannel.configureBlocking(false);
        //connect server
        socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), PORT));
        //init Selector
        Selector selector = Selector.open();
        //register event
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        while (selector.isOpen() && selector.select() > 0) {
            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();

            while (selectionKeys.hasNext()) {
                SelectionKey key = selectionKeys.next();

                selectionKeys.remove();
                if (key.isValid() && key.isConnectable()) {
                    log.info("client is connecting server...");
                    //处理链接
                    connect(selector, key);
                } else if (key.isValid() && key.isReadable()) {
                    log.info("receive from server");
                    //读取数据
                    read(selector, key);
                } else if (key.isValid() && key.isWritable()) {
                    log.info("send to server");
                    //写数据
                    write(selector, key);
                }

            }

        }
    }

    /**
     * 对应client的 connect
     *
     * @param selector
     * @param key
     * @return {@link Void}
     * @author cyzc
     * @since 2022/11/29 9:46
     */
    private void connect(Selector selector, SelectionKey key) throws IOException {
        //1.获得 tcp协议通信的通道
        SocketChannel socketChannel = (SocketChannel) key.channel();
        //2.完成链接
        socketChannel.finishConnect();
        //3. 链接成功
        if (socketChannel.finishConnect()) {
            log.info("connect success");
        }
        //4. channel设置为非阻塞
        socketChannel.configureBlocking(false);
        //5. 绑定selector,写出事件
        socketChannel.register(selector, SelectionKey.OP_WRITE);

    }

    /**
     * 从server端 读数据
     *
     * @param selector
     * @param key
     * @return {@link Void}
     * @author cyzc
     * @since 2022/11/29 10:06
     */
    private void read(Selector selector, SelectionKey key) throws IOException {
        //1.获得 tcp协议通信的通道
        SocketChannel socketChannel = (SocketChannel) key.channel();
        //2. 分配Buffer
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

        //读是将channel的数据读到Buffer中
        //init byte receive data
        byte[] bytes = new byte[BUFFER_SIZE * 2];
        //init byte array index
        int index = 0;
        //3. 将数据读到Buffer,循环终止条件时socketChannel 中没有数据
        while (socketChannel.read(buffer) != 0) {
            //写完数据之后，将模式切换为读模式，避免socketChannel中再被写入数据，以免出现脏数据
            buffer.flip();
            //开始将Buffer中的数据读到 bytes[]中，buffer.get();一次读取一个字节，这里也可以使用for循环
            while (buffer.hasRemaining()) {
                bytes[index++] = buffer.get();
            }
            //clear buffer
            buffer.clear();
        }
        log.info("client read from server:" + new String(bytes, 0, index, StandardCharsets.UTF_8));
        //继续注册写入事件，为什么是注册写入事件呢？ 这个写入是针对谁来说的？？还是针对服务端，服务端发现有 write的channel 就可以向该channel写入数据，这样client就可以读取channel的数据
        socketChannel.register(selector, SelectionKey.OP_WRITE);
    }

    private void write(Selector selector, SelectionKey key) throws IOException {
        //1. .获得 tcp协议通信的通道
        SocketChannel socketChannel = (SocketChannel) key.channel();
        //2. 分配字节数组
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        //3.写数据时 先清除缓存
        buffer.clear();
        //4. 将数据写入缓存
        buffer.put(ByteBuffer.wrap(scanner.nextLine().getBytes(StandardCharsets.UTF_8)));
        //5.
        if (socketChannel.isConnected()) {
            socketChannel.configureBlocking(false);

            while (buffer.hasRemaining()) {
                //将buffer中的数据写入到 socketChannel中
                socketChannel.write(buffer);
            }
        }
        //继续注册为 读事件？  这是为什么呢？？？？？？ 因为我写入了数据，是想让服务端读数据的，服务端判断为读事件时，才会从该socketChannel读取数据
        socketChannel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_ACCEPT);

    }

}
