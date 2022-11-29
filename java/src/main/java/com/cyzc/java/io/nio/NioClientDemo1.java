package com.cyzc.java.io.nio;

import com.cyzc.java.io.MyIOUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/28 16:01]
 */
@Slf4j
public class NioClientDemo1 {

    public static void main(String[] args) throws IOException {
        //client SocketChannel对象，设置非阻塞，绑定端口
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(5680);

        //判断是否 connect 成功，如果没成功返回log
        if (!socketChannel.connect(inetSocketAddress)){
            while (!socketChannel.finishConnect()){
                log.info("客户端正在链接，请耐心等待");
            }
        }
        // channel 是和buffer 一起使用的，通过channel.write(buffer) 将数据写到 channel中
        ByteBuffer byteBuffer = ByteBuffer.wrap("sayHi".getBytes());
        socketChannel.write(byteBuffer);

        ByteBuffer read = ByteBuffer.allocate(1024);

        String result=null;
        while (socketChannel.read(read)!=-1){
            result = MyIOUtils.readDataFromSocketChannel(socketChannel, 1024);
        }
        log.info("返回数据："+result);

        socketChannel.close();
    }
}
