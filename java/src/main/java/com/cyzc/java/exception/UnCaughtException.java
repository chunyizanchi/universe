package com.cyzc.java.exception;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/23 16:50]
 */
public class UnCaughtException {

    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("当前线程处理不了异常，快来看看~"+"线程名称:"+t.getName()+":exception:"+e.getMessage());
            }
        });


        int i=1/0;

    }
   // int i=1/0;
    /*
        public static void main(java.lang.String[]);
        Code:
        0: iconst_1
        1: iconst_0
        2: idiv  i divide
        3: istore_1
        4: return
    }*/

    //catch
    /*public static void main(java.lang.String[]);
    Code:
            0: iconst_1
       1: iconst_0
       2: idiv
       3: istore_1
       4: goto          12
               7: astore_1 target：处理异常的指令
       8: aload_1
       9: invokevirtual #3                  // Method java/lang/Exception.printStackTrace:()V
            12: return
    Exception table:
    from    to  target type
           0     4     7   Class java/lang/Exception*/
}
