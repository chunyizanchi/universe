package com.cyzc.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/25 09:58]
 */
public class URLDemo {

    public static void main(String[] args) throws IOException {
        URL url= new URL("http://www.baidu.com");
        InputStream inputStream = url.openStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
                StandardCharsets.UTF_8);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;

        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }

}
