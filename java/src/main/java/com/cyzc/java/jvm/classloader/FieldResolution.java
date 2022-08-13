package com.cyzc.java.jvm.classloader;

/**
 * 注释掉 {@link Sub.A } 会报如下错误。因为匹配无法匹配相应的
 * <>Reference to 'A' is ambiguous, both 'Parent.A' and 'InterFace2.A' match</>
 * @author Cyzc
 * @since [2021/11/20 20:08]
 */
public class FieldResolution {

    interface InterFace0{
        int A=0;
    }
    interface Interface1 extends InterFace0{
        int A=1;
    }
    interface InterFace2{
        int A=2;
    }
    static class Parent implements Interface1{
        public static int A=3;
    }
    static class Sub extends Parent implements InterFace2{
       public static int A=4;
    }
    public static void main(String[] args) {
        System.out.println(Sub.A);
    }

}
