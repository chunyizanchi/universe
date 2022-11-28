package com.cyzc.java.io.nio;

import com.cyzc.java.io.MyIOUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/28 16:01]
 */
@Slf4j
public class NioServer1 {

    public static void main(String[] args) throws IOException {
        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8888);
        //绑定端口号
        serverSocketChannel.socket().bind(inetSocketAddress);
        //设置为 non-blocking
        serverSocketChannel.configureBlocking(false);
        //创建selector
        Selector selector = Selector.open();
        //将 serverSocketChannel 注册到 selector 上，并绑定事件， ServerSocketChannel负责与客户端链接 只能绑定accept事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            //监听所有的channel
            selector.select(1000);
            //走到这说明
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //准备遍历 SelectionKey
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                //
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isValid() && selectionKey.isAcceptable()) {
                    //思考一下，如果来了一个连接事件该如何处理
                    //为该链接创建一个 SocketChannel。
                    SocketChannel accept = serverSocketChannel.accept();
                    //
                    accept.configureBlocking(false);
                    log.info("clint:" + accept.getLocalAddress() + "==is connected");
                    //注册响应事件到selector
                    accept.register(selector,
                            SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT);
                } else if (selectionKey.isValid() && selectionKey.isReadable()) {

                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    String result = MyIOUtils.readDataFromSocketChannel(socketChannel, 1024);

                    log.info("client:" + socketChannel.getLocalAddress() + ":send==" + result+"===currentThread:"+Thread.currentThread().getName());
                    socketChannel.close();
                } /*else if (selectionKey.isValid() && selectionKey.isWritable()) {
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    String result = "请求收到，回复响应";

                    allocate.put(result.getBytes());
                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    channel.write(allocate);

                }*/
                iterator.remove();
            }


        }


    }

    String readDataFromChannel(SocketChannel channel) throws IOException {

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        StringBuilder stringBuilder = new StringBuilder();

        while (true) {

            byteBuffer.clear();

            int read = channel.read(byteBuffer);

            if (read == -1) {
                break;
            }

            //现在是写模式，将数据写到buffer中， buffer的元素有 position，limit,capacity
            //切换为读模式
            byteBuffer.flip();
            //现在byte有效长度就是limit。遍历一下将position-limit的数据拿出来
            // 我需要怎么做？ 需要将byte数组转为char数组
            int limit = byteBuffer.limit();

            char[] chars = new char[limit];

            for (int i = 0; i < limit; i++) {

                chars[i] = (char) byteBuffer.get(i);
            }
            stringBuilder.append(chars);
            byteBuffer.clear();
        }
        return stringBuilder.toString();


    }
}
