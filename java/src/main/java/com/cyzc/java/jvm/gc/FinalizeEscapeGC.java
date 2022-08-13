package com.cyzc.java.jvm.gc;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-08-20
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK=null;

    public void isAlive(){
        System.out.println("yes i am still alive :)");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        System.out.println("finalize()   executed");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK=new FinalizeEscapeGC();

        SAVE_HOOK=null;

        System.gc();

        Thread.sleep(500);

        if (SAVE_HOOK!=null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("i am gc");
        }

        SAVE_HOOK=null;

        System.gc();

        Thread.sleep(500);

        if (SAVE_HOOK!=null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("i am gc");
        }
    }
}