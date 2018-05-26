package com.chenleon.algo.ch1basic;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node first = null;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = first;

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

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(4);
        stack.push(7);
        stack.push(9);
        stack.push(10);
        stack.pop();

        for (Integer item : stack) {
            StdOut.println(item);
        }
    }
}
