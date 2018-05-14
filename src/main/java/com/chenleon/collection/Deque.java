package com.chenleon.collection;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        assertNotNullItem(item);

        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        if (oldHead == null) tail = head;
        else oldHead.prev = head;
        size++;
    }

    public void addLast(Item item) {
        assertNotNullItem(item);

        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        tail.prev = oldTail;

        if (oldTail == null) head = tail;
        else oldTail.next = tail;
        size++;
    }

    public Item removeFirst() {
        assertNotEmptyDeque();

        Item item = head.item;
        head = head.next;

        if (head == null) tail = null;
        else head.prev = null;

        size--;
        return item;
    }

    public Item removeLast() {
        assertNotEmptyDeque();

        Item item = tail.item;
        tail = tail.prev;

        if (tail == null) head = null;
        else tail.next = null;

        size--;
        return item;
    }

    private void assertNotNullItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Item must not be null");
    }

    private void assertNotEmptyDeque() {
        if (isEmpty()) throw new NoSuchElementException("Empty Deque");
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                assertNotEmptyDeque();

                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    class Node {
        Item item;
        Node next;
        Node prev;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.addLast(5);
        deque.addLast(6);
        StdOut.printf("The size: %d\n", deque.size());
        for (Integer i : deque) {
            StdOut.println(i);
        }
    }
}
