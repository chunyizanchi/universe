package com.cyzc.java.jvm.oom;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-11-03
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread=new Thread(this::dontStop);
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom=new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}