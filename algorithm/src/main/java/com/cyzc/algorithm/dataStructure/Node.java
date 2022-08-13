package com.cyzc.algorithm.dataStructure;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/14 16:20]
 */
public class Node {

    public String item;

    public Node next;

    public Node(String item, Node next) {
        this.item = item;
        this.next = next;
    }

    public Node(String item) {
        this.item = item;
    }

    public Node() {
    }

    void item() {
        this.item = item;
    }

    void next(Node next) {
        this.next = next;
    }
}
