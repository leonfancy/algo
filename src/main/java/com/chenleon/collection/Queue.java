package com.chenleon.collection;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    private Node head;
    private Node tail;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    class Node {
        T item;
        Node next;
    }

    public void enqueue(T item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        if (isEmpty()) head = tail;
        else oldTail.next = tail;
    }

    public T dequeue() {
        T item = head.item;
        head = head.next;
        if (isEmpty()) tail = null;
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args)
    {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(4);
        queue.enqueue(7);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.dequeue();

        for (Integer item : queue) {
            StdOut.println(item);
        }
    }
}
