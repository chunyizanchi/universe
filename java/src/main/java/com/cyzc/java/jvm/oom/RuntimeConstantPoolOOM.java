package com.cyzc.java.jvm.oom;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-11-04
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
      /*  Set<String> set=new HashSet<>();
        short i=0;
        while (true){
          set.add(String.valueOf(i++).intern());
        }*/

        String str1=new StringBuilder("11111").append("2222222AA").toString();
        System.out.println(str1.intern()==str1);

        String str2= "jav" + "va";
        System.out.println(str2.intern()==str2);
    }

}