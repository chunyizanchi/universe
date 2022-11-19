package com.cyzc.java.annotation;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/18 16:10]
 */
public class TestMethodAnnotation {


    @Override
    @MyMethodAnnotation(title = "toStringMethod", description = "override toString method")
    public String toString() {
        return "Override toString method";
    }

    @Deprecated
    @MyMethodAnnotation(title = "old static method", description = "deprecated old static method")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyMethodAnnotation(title = "test method", description = "suppress warning static method")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }


    public static void main(String[] args) throws ClassNotFoundException {

        Method[] methods = TestMethodAnnotation.class.getClassLoader()
                .loadClass("com.cyzc.java.annotation.TestMethodAnnotation").getMethods();

        System.out.println(methods);

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyMethodAnnotation.class)) {
                for (Annotation declaredAnnotation : method.getDeclaredAnnotations()) {
                    System.out.println("Annotation in Method '"
                            + method + "' : " + declaredAnnotation);
                }
                MyMethodAnnotation annotation = method.getAnnotation(MyMethodAnnotation.class);
                String title = annotation.title();
                String description = annotation.description();
                System.out.println("method:"+method.getName()+":title:" + title + ":description:" + description);
            }
        }

    }
}
