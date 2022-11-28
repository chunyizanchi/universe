package com.cyzc.java.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/28 17:20]
 */
public class MyIOUtils {


    public static String readDataFromSocketChannel(SocketChannel socketChannel, int capacity) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(capacity);

        StringBuilder result=new StringBuilder();

        while (true){
            buffer.clear();

            int read = socketChannel.read(buffer);
            //说明读完数据了
            if (read==-1){
                break;
            }
            //切换读写
            buffer.flip();

            //现在有效数据只有 position->limit
            int limit = buffer.limit();

            char[] chars = new char[limit];

            //将 buffer中的字节数据转换为字符数据
            for (int i = 0; i < limit; i++) {

                chars[i] = (char) buffer.get(i);
            }

            result.append(chars);
            buffer.clear();

        }

        return result.toString();


    }

}
