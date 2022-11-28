package com.cyzc.java.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>  一个 SocketClientRequestThread 线程模拟一个客户端请求
 *
 * @author Cyzc
 * @since [2022/11/27 11:17]
 */
@Slf4j
public class SocketClientRequestThread implements Runnable {

    private CountDownLatch countDownLatch;

    //线程编号
    private Integer clientIndex;


    /**
     *
     * @param countDownLatch Java 提供的同步器
     * @param clientIndex 代表客户端
     * @since 2022/11/27 15:10
     */
    public SocketClientRequestThread(CountDownLatch countDownLatch, Integer clientIndex) {
        this.countDownLatch = countDownLatch;
        this.clientIndex = clientIndex;
    }

    @Override
    public void run() {
        Socket socket = null;
        //fixme 为什么clientRequest使用的 OutPutStream,为什么clientResponse使用的InputStream,这是针对什么来说的输入流输出流。想一下哦
        OutputStream clientRequest = null;
        InputStream clientResponse = null;

        try {
            //初始化socket 对象，绑定ip,port
            socket = new Socket("localhost", 83);
            //获取 socket对象的输入输出流。
            // 那我明白了 这个socket是链接的 服务端和客户端，针对客户端来说，一个socket 有input 也有output。
            //input 指的是 客户端socket 接收的消息，相对的是客户端收到的来自 服务端的响应。
            //output 指的是 客户端socket 发出的消息,针对的是客户端发送给服务端的信息。
            //所以 clientResponse=>input  clientRequest=>output
            //画一张图会好点理解
            clientRequest = socket.getOutputStream();
            clientResponse = socket.getInputStream();
            //阻塞等待，直到 countDownLatch.countDown降为0再启动
            //等待，直到SocketClientDaemon完成所有线程的启动，然后所有线程一起发送请求
            countDownLatch.await();
            //将信息写到 clientRequest 中，这也能解释为什么 clientRequest是一个OutPutStream
            clientRequest.write(("这是第" + this.clientIndex
                    + "个客户端的请求发送完成，等待服务器返回信息").getBytes());
            //限制字节数大小限制
            int maxLen = 1024;
            //转换为字节容量
            byte[] contextBytes = new byte[maxLen];
            //字节真实长度
            int realLen;
            StringBuilder message = new StringBuilder();

            // 一个while循环，条件是从socket的inputStream中没有读到数据
            // inputStream.read方法是将inputStream里的信息读到 contextBytes 中
            // 一定要多注意 inPutStream.read 方法和  outPutStream.write方法中的参数的意思
            //比如 inPutStream.read 是将消息读到 contextBytes里
            // outPutStream则是将 表达式写到 outPutStream里，然后发送出去。
            // 所以，一目了然~
            while ((realLen = clientResponse.read(contextBytes, 0, maxLen)) != -1) {
                //拼接返回的信息
                message.append(new String(contextBytes, 0, realLen));
            }
            log.info("接受来自服务器的信息：" + message);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }finally {

            try {
                if (clientRequest!=null){
                    clientRequest.close();
                }
                if (clientResponse!=null){
                    clientResponse.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }

        }

    }
}
