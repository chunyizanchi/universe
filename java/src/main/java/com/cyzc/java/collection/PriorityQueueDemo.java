package com.cyzc.java.collection;


import com.cyzc.java.entity.Student;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * <> 优先队列使用的堆
 *
 * @author Cyzc
 * @since [2021/12/16 19:05]
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<String>();
        //入列
        q.offer("3");
        q.offer("4");
        q.offer("1");
        q.offer("2");
        q.offer("5");

        HashSet<Object> objects = new HashSet<>();
        //出列
        System.out.println(q.poll());  //1
        System.out.println(q.poll());  //2
        System.out.println(q.poll());  //3
        System.out.println(q.poll());  //4
        System.out.println(q.poll());  //5


        PriorityQueue<Student> studentQueue=new PriorityQueue<Student>(
                (x,y)->y.getScore().compareTo(x.getScore()));

        studentQueue.offer(new Student("3",3));
        studentQueue.offer(new Student("1",1));
        studentQueue.offer(new Student("4",4));
        studentQueue.offer(new Student("2",2));



        System.out.println(studentQueue.poll());
        System.out.println(studentQueue.poll());
        System.out.println(studentQueue.poll());
        System.out.println(studentQueue.poll());

        TreeMap treeMap=new TreeMap();

    }




}
