package com.cyzc.netty.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 *   流程 1.监听指定接口,服务端接收客户端的链接请求，
 * @author Cyzc
 * @since [2022/07/28 17:03]
 */
public class BioServerDemo {

    public static void main(String[] args) throws IOException {
        //创建一个 Socket链接
        ServerSocket serverSocket = new ServerSocket(5678);

        System.out.println("Server Socket 创建成功，服务器启动==");

        AtomicLong atomicInteger = new AtomicLong(0L);
        while (true) {
            atomicInteger.getAndIncrement();
            System.out.println("主线程：准备接收客户端链接");
            //accept 方法会阻塞，一直等到客户端链接
            Socket accept = serverSocket.accept();

            System.out.println("主线程：收到一份客户端请求");
            System.out.println("主线程：ip:" + accept.getInetAddress().getHostAddress());
            System.out.println("主线程：端口:" + accept.getPort());
            new Thread(() -> handler(accept)).start();
        }


    }

    public static void handler(Socket socket) {
        System.out.println(
                "子线程【" + Thread.currentThread().getName() + "】：服务端正在与【" + socket.getPort()
                        + "】端口进行交互");

        while (true) {
            byte[] bytes = new byte[4096];

            try {
                InputStream inputStream = socket.getInputStream();
                System.out.println(
                        "子线程【" + Thread.currentThread().getName() + "】:读取客户端发来的信息");
                //阻塞
                int read = inputStream.read(bytes);

                if (read == -1) {
                    System.out.println(
                            "子线程【" + Thread.currentThread().getName() + "】: 客户端关闭了请求");
                    socket.close();
                    break;
                }
                String s = new String(bytes, 0, read);
                System.out.println("子线程【" + Thread.currentThread().getName() + "】: 打印客户端发过来的消息:+"
                        + s);

                if ("sayHi".equals(s)) {

                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("hello client".getBytes());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }
}
