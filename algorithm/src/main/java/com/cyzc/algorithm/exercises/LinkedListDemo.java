package com.cyzc.algorithm.exercises;

import com.cyzc.algorithm.dataStructure.Node;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/14 16:24]
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        //声明节点
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();
        //赋值
        first.item = "to";
        second.item = "be";
        third.item = "or";
        //构造链表
        first.next = second;
        second.next = third;
        //增加一个头结点，声明一个结点，让这个结点的指针指向头结点
        Node fourth = new Node();
        fourth.item="not";
        fourth.next=first;
        //增加一个尾结点，声明一个结点，让尾结点的指针指向该节点
        Node fifth = new Node();
        fifth.item="to";
        //尾结点指向新节点
        third.next=fifth;

        //删除头结点
        fourth.next=null;

        //遍历链表
        for(Node one=first;one!=null;one=one.next){
            System.out.println(one.item);
        }
    }

}
