package com.cyzc.java.io.nio;

import com.cyzc.java.io.MyIOUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <p> nio 需要注意什么呢？
 *  NIO 组件
 *  <br>Selector :多路选择器，ServerSockerChannel注册一个selector,并监听ACCEPT事件
 *  <br>Buffer：buffet nio神器，buffer主要是 channel用来读写数据的，channel可以从buffer中读数据，也可以向buffer中写数据。
 *  Buffer有几个需要注意的参数 position,capacity,limit。position是当前操作的位置，limit是最大操作值，capacity是Buffer容量
 *  向buffer写数据时 参数如何变化，从Buffer读数据时，参数如何变化  filp 读写模式转换， 读模式不可以写数据，写模式可以读数据
 *  <br>Channel：channel可以看做和 putStream一样，只不过，channel可以读，可写。
 * @author Cyzc
 * @since [2022/11/24 16:03]
 */
public class NioServerDemo1 {

    public static void main(String[] args) throws IOException {
        //开启一个Selector
        Selector selector = Selector.open();
        //只有ServerSocketChannel 可以被Selector监听
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //Channel 必须设置为 non-blocking 。不然使用选择器就没有意义了
        serverSocketChannel.configureBlocking(false);
        //将Selector 注册到 ServerSocketChannel上，注册为 ACCEPT事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //得到 SocketChannel 里面的任意一个ServerSocket.
        //keypoint 20221127 只有服务端才有ServerSocket，和ServerSocketChannel
        ServerSocket serverSocket = serverSocketChannel.socket();
        //设置监听的ip地址和端口号。 如果端口来了socket 就开始处理
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);

        serverSocket.bind(inetSocketAddress);

        while (true) {
            //#select 监听事件,这个方法会阻塞住，直到有socket事件到达
            selector.select();

            //获得到达的事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {

                SelectionKey selectionKey = keyIterator.next();

                //ServerSocketChannel 才能处理这个事件,
                //如果是 OP_ACCEPT 需要为ServerSocketChannel 创建一个SocketChannel,来建立链接
                if (selectionKey.isAcceptable()) {
                    //
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();

                    // 服务器会为每个**新连接**创建一个 SocketChannel
                    SocketChannel sChannel = serverSocketChannel1.accept();
                    //设置为非阻塞
                    sChannel.configureBlocking(false);
                    //新SocketChannel主要从客户端读取数据
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    System.out.println(
                            "读到来自客户端的数据：" + MyIOUtils.readDataFromSocketChannel(channel,1024));
                    channel.close();
                }
                keyIterator.remove();

            }


        }

    }

}
