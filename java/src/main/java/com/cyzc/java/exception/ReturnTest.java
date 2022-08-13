package com.cyzc.java.exception;

/**
 * <p>
 * //finally 里return 字节码里会没有 athrow指令，所以就抛不出异常
 * @author Cyzc
 * @since [2022/07/22 06:57]
 */
public class ReturnTest {

    public static void main(String[] args) {

        Integer integer = returnTest();
        System.out.println(integer);

    }

    public static Integer returnTest() {

        try {
            int i = 10 / 0;
            return i;
        } /*catch (Exception e) {
            return 2;
        }*/ finally {
            //finally 里return 字节码里会没有 athrow指令，所以就抛不出异常
            return 1;
        }
    }
}
