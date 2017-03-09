package my.javase.study.datastructure;

/**
 * Created by xpcomrade on 2016/7/12.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: (单链表). <br/>
 */
public class LinkedList<T> {

    private Node<T> head,tail;

    public LinkedList(){
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * add head node
     * @param item
     */
    public void addHead(T item) {
        head = new Node<T>(item);
        if (tail == null) {
            tail = head;
        }
    }

    /**
     * add tail
     * @param item
     */
    public void addTail(T item) {
        if (isEmpty()) {
            head = tail = new Node<T>(item);
        } else {
            tail.next = new Node<T>(item);
            tail = tail.next;
        }
    }

    public int indexOf(T item) {
        int index = 0;

        Node<T> p;
        for (p = head; p != null; p = p.next) {
            if (item.equals(p.data)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }


    public void removeFromHead(){
        if (isEmpty()) {
            throw new IllegalArgumentException("the list is empty");
        } else {
            head = head.next;
        }
    }

    public void removeFromTail() {
        Node<T> prev = null, curr = head;
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
            if (curr.next == null) {
                prev.next = null;
            }
        }
    }


    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        Node(T data) {
            this(data, null);
        }
    }
}
