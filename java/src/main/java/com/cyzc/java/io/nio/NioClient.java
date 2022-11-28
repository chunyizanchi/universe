package com.cyzc.java.io.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * <p> 模拟客户端
 *
 * @author Cyzc
 * @since [2022/11/24 16:32]
 */
public class NioClient {

    public static void main(String[] args)  {

        try {
            //客户端提供一个 Socket就行
            Socket socket = new Socket("127.0.0.1", 8888);
            //客户端的 outPutStream 就是 要发送的信息 request
            OutputStream outputStream = socket.getOutputStream();
            String s = "hello world";
            // outputStream.write 字节写到OutPutStream中
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
