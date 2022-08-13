package com.cyzc.java.basic;

/**
 * hashCode 存在相等的情况：因为 31 。如果hashcode没有冲突那么为什么hashmap需要hash和equal方法来指定元素，以及为什么使用拉链法解决hash冲突呢 ？是吧
 *
 * @author Cyzc
 * @since [2022/03/03 16:35]
 */
public class HashCodeTest {

    public static void main(String[] args) {
        System.out.println("Aa ="+"Aa".hashCode());
        System.out.println("BB ="+"BB".hashCode());

        System.out.println("AaBBBB ="+"AaBBBB".hashCode());

    }
}
