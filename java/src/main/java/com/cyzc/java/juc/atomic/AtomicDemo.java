package com.cyzc.java.juc.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/20 23:10]
 */
public class AtomicDemo {

    public static void main(String[] args) {
        Employee employee=new Employee(123,"name");
        AtomicMarkableReference<Employee>  employeeNode=new AtomicMarkableReference<>(employee,true);

        employee.setId(222);
        System.out.println("employee 222 ==="+employee);
        employee.setId(123);
        System.out.println("employee 123 ==="+employee);

        final Employee reference = employeeNode.getReference();
        System.out.println("getReference ==="+reference);
        final boolean marked = employeeNode.isMarked();
        System.out.println(marked);

    }


}
