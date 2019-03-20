package com.example.demo.common.suanshu;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-19 17:14
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node() {
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }


}
