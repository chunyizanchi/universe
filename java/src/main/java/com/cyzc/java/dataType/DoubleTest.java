package com.cyzc.java.dataType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * <p>
 * 浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用 equals 来判断。
 *  浮点数没有办法用二进制精确表示，因此存在精度丢失的风险。 不过，Java 提供了BigDecimal 来操作浮点数。BigDecimal 的实现利用到了 BigInteger （用来操作大整数）, 所不同的是 BigDecimal 加入了小数位的概念。
 * @author Cyzc
 * @since [2022/07/20 22:47]
 */
public class DoubleTest {

    public static void main(String[] args) {
        //double 整数相乘其实就是 0.1+0.1+0.1 因为是二进制，
        double v = 0.1 * 3;   //0.30000000000000004

        Double aDouble = 0.1 + 0.1 + 0.1;  //0.30000000000000004

        double s = 0.3;

        System.out.println(Double.compare(v, s));  //1

        BigDecimal a = new BigDecimal("1.0"); //使用字符串定义
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b); // subtract 方法相减
        BigDecimal y = b.subtract(c);
        // add 相加
        BigDecimal add = a.add(b);
        // multiply 相乘
        BigDecimal multiply = a.multiply(b);
        // divide 相除
        BigDecimal divide = a.divide(b);
        //BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode)  scale：保留小数位
        BigDecimal divide2 = a.divide(b, 2, RoundingMode.HALF_UP);

        // compareTo 比较大小
        int i = a.compareTo(b);

        System.out.println(x); /* 0.1 */
        System.out.println(y); /* 0.1 */
        System.out.println(Objects.equals(x, y)); /* true */

    }

}
