package com.cyzc.java.basic;

/**
 * <p> 将整数数组转换成字符串。 主要是 , 需要使用Springbuilder 拼接
 *
 * @author Cyzc
 * @since [2022/07/14 11:06]
 */
public class IntArrayToString {

    public static void main(String[] args) {

        String connectwiths = utils.connectwiths(1, 2, 3, 4, 5);
        System.out.println(connectwiths);
    }

    public static class utils {
        public static StringBuffer stringBuilder;

        public static String connectwiths(Integer...array){
            stringBuilder=new StringBuffer();
            for (Integer I:array){
                stringBuilder.append(I).append(",");
            }
            return stringBuilder.toString();
        }

    }
}
