package com.cyzc.java.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * <p> 字节码长度。，获取字符串所占字节的长度。 这个东西和编码形式相关，需要注意一下。
 *
 * @author Cyzc
 * @since [2022/07/20 23:29]
 */
public class CharacterDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String test = "abc男efg";
        String test1 = "abcefg";
        String test3 = "男";

        int length = test1.length();
        int length1 = test.length();
        //charsetName
        int unicode1 = test.getBytes("UNICODE").length;
        int unicode2 = test1.getBytes("UNICODE").length;
        int unicode3 = test3.getBytes("UNICODE").length;

        int utf8A = test.getBytes(StandardCharsets.UTF_8).length;
        int utf8B = test1.getBytes(StandardCharsets.UTF_8).length;
        int utf8C = test3.getBytes(StandardCharsets.UTF_8).length;

        System.out.println(unicode1);
        System.out.println(unicode2);
        System.out.println(unicode3);

        System.out.println(utf8A);
        System.out.println(utf8B);
        System.out.println(utf8C);
    }

}
