package com.cyzc.java.jvm.oom;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-11-03
 */
public class JavaVMStackSOF {

    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {

        JavaVMStackSOF oom=new JavaVMStackSOF();

        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:"+oom.stackLength);
            e.printStackTrace();
            throw e;

        }

    }


}