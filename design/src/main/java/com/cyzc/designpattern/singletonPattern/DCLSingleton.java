package com.cyzc.designpattern.singletonPattern;

/**
 * <p>双重校验锁</p>
 *
 *   private static volatile DCLSingleton instance;<br>
 *   一定要加 volatile 否则，重排序会返回一个未初始过的 单例 <br>
 *
 *
 * @author Cyzc
 * @since [2021/12/26 11:17]
 */
public class DCLSingleton {

    private DCLSingleton(){

    }
    // 不加 volatile 可能会返回一个未初始化 过的instance
    private static volatile DCLSingleton instance;

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }


    /*
     *
        10: monitorenter
        11: getstatic     #2                  // Field instance:Lcom/cyzc/designpattern/singletonPattern/DCLSingleton;
        14: ifnonnull     27
        17: new           #3                  // class com/cyzc/designpattern/singletonPattern/DCLSingleton
        20: dup
        21: invokespecial #4                  // Method "<init>":()V
        24: putstatic     #2                  // Field instance:Lcom/cyzc/designpattern/singletonPattern/DCLSingleton;
        27: aload_0
        28: monitorexit
     */
}
