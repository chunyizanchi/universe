package com.cyzc.netty.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/28 17:50]
 */
public class NioServerDemo {

    private Selector selector;

    public static void main(String[] args) throws IOException {

        NioServerDemo nioServerDemo = new NioServerDemo();
        nioServerDemo.initServer(5680);
        nioServerDemo.listen();
    }

    public void initServer(int port) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        //设置为非阻塞
        channel.configureBlocking(false);
        //获得一个 selector
        this.selector = Selector.open();
        //channel 绑定端口
        channel.bind(new InetSocketAddress(port));
        //注册事件
        channel.register(selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * 使用轮询的方式监听selector 上是否有需要处理的对象，如果有就进行处理。
     * @author cyzc
     * @return {@link Void}
     * @since 2022/7/28 18:34
     */
    public void listen() throws IOException {

        SocketChannel socketChannel = null;

        while (true) {

            int select = selector.select();
            System.out.println("select:"+select);

            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();

                iterator.remove();

                if (next.isAcceptable()) {
                    System.out.println("接收到客户端链接请求");
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) next.channel();

                    socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);

                    socketChannel.register(this.selector, SelectionKey.OP_READ);
                } else if (next.isReadable()) {
                    read(next);
                }


            }


        }
    }

    public void read(SelectionKey key) throws IOException {
        // 服务器可读取消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        channel.read(buffer);
        byte[] data = buffer.array();

        int sum = 0;
        for (byte datum : data) {
            sum += datum;
        }
        if (sum == 0) {
            key.cancel();
            return;
        }
        String msg = new String(data).trim();
        System.out.println(">>>收到客户端消息：" + msg);

        if (msg.equals("sayHi")) {
            String reback = "hello,client, I am NIO server..";
            ByteBuffer outBuffer = ByteBuffer.wrap(reback.getBytes(StandardCharsets.UTF_8));
            // 将消息回送给客户端
            channel.write(outBuffer);
        }
    }


}
