package com.cyzc.java.io.bio;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 单线程BIO 接受客户端请求
 * <br>serverSocket.accept() & InPutStream.read 是会阻塞的</>
 * @author Cyzc
 * @since [2022/11/27 11:33]
 */
@Slf4j
public class SocketServer1 {

    public static void main(String[] args) throws IOException {
        // 实例化 ServerSocket 对象。注意ServerSocket 对象是啥，是干啥的
        ServerSocket serverSocket = new ServerSocket(83);

        while (true) {
            try {
                //通过serverSocket.accept(); 返回一个Socket
                Socket socket = serverSocket.accept();
                //in 指的是 server端接收到的数据，out指的是server端发送出去的数据
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                //port
                int port = socket.getPort();

                int maxLen = 2048;
                byte[] contextBytes = new byte[maxLen];
                //将 inputStream 接受到的数据读到 contextBytes 中
                int readLen = in.read(contextBytes, 0, maxLen);
                //将 byte 转换为String对象
                String message = new String(contextBytes, 0, readLen);

                log.info("服务器接收到来自端口：" + port + "的信息" + message);
                //开始写数据，将表达式写入到 outPut里
                out.write("回发响应信息！".getBytes());

                //关闭资源
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            } finally {

                if (serverSocket != null) {
                    serverSocket.close();
                }

            }
        }


    }

}
