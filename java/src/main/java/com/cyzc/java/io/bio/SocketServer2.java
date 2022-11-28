package com.cyzc.java.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/27 11:42]
 */
@Slf4j
public class SocketServer2 {

    public static void main(String[] args) throws IOException {
        //创建ServerSocket对象，可以使用try with resource
        try (ServerSocket serverSocket = new ServerSocket(83)) {
            while (true) {
                //serverSocket.accept(); 得到一个Socket对象，只能接受到一个Socket,多线程是处理的这个Socket传过来的信息
                Socket socket = serverSocket.accept();
                //当然业务处理过程可以交给一个线程(这里可以使用线程池),并且线程的创建是很耗资源的。
                //最终改变不了.accept()只能一个一个接受socket的情况,并且被阻塞的情况
                SocketServerThread socketServerThread = new SocketServerThread(socket);
                new Thread(socketServerThread).start();
            }
        } catch (Exception e) {
            SocketServer2.log.error(e.getMessage(), e);
        }
    }


}

@Slf4j
class SocketServerThread implements Runnable {

    //通过构造函数穿过来的socket 就是我们当前线程要处理的 socket
    private Socket socket;

    public SocketServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
           //socket 的 inputStream 就是我们接受过来的信息
            in = socket.getInputStream();
            // outPutSteam就是我们要发送的响应的信息
            out = socket.getOutputStream();
            //获取端口
            int sourcePort = socket.getPort();
            int maxLen = 1024;
            byte[] contextBytes = new byte[maxLen];
            //使用线程，同样无法解决read方法的阻塞问题，
            //也就是说read方法处同样会被阻塞，直到操作系统有数据准备好
            int realLen = in.read(contextBytes, 0, maxLen);
            //读取信息
            String message = new String(contextBytes, 0, realLen);

            //下面打印信息
            SocketServerThread.log.info(
                    "服务器收到来自于端口: " + sourcePort + "的信息: " + message);

            //下面开始发送信息
            out.write("回发响应信息！".getBytes());
        } catch (Exception e) {
            SocketServerThread.log.error(e.getMessage(), e);
        } finally {
            //试图关闭
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (this.socket != null) {
                    this.socket.close();
                }
            } catch (IOException e) {
                SocketServerThread.log.error(e.getMessage(), e);
            }
        }
    }
}

