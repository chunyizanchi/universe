package com.cyzc.java.juc.thread;

/**
 * <p> 使用wait ,notifyAll 编程的核心是什么呢？ </p>
 * 在我看来首先要理解 线程状态流转，Object.wait()可以让 线程状态由 Runnable -> Waiting。这时候线程是被挂起了，等待被唤醒
 * 其他线程如果想占有锁对象就需要 使用Object.notifyAll 方法来获取锁。 所以首先要调用 Object.notify方法拿到锁，然后执行任务，再释放锁。
 * 放在代码中就是我达到某个条件之后，调用Object.wait 方法，释放对象，让其他线程得以执行
 *
 * @author Cyzc
 * @since [2022/11/19 22:33]
 */
public class WaitAndNotifyDemo2 {

    public static void main(String[] args) {

        WaitAndNotifyDemo2 waitAndNotifyDemo2=new WaitAndNotifyDemo2();
        new Thread(new PrintNumber(waitAndNotifyDemo2)).start();
        new Thread(new PrintLetter(waitAndNotifyDemo2)).start();

    }

}
//每输出两个数字，wait一下
class PrintNumber implements Runnable{

    Object object;

    public PrintNumber(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            for (int i = 1; i < 53; i++) {
                System.out.println(i);
                if (i%2==0){
                   object.notifyAll();
                    System.out.println("PrintNumber 调用了 object.notifyAll();");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        object.notifyAll();

    }
}

class PrintLetter implements Runnable{

    Object object;

    public PrintLetter(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            for (int i = 0; i < 26; i++) {
                System.out.println((char)(i+'A'));
                object.notifyAll();

                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        object.notifyAll();
    }
}
