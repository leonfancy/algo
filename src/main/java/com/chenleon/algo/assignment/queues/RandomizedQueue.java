package com.chenleon.algo.assignment.queues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size = 0;

    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("item must not be null");
        if (size == items.length) resize(2 * size);
        items[size++] = item;
    }

    public Item dequeue() {
        assertNoneEmpty(size);
        int index = StdRandom.uniform(size);
        Item item = items[index];
        items[index] = items[--size]; // move the last item to target place
        items[size] = null;
        if (size > 0 && size == items.length / 4) resize(items.length / 2);
        return item;
    }

    private void assertNoneEmpty(int size) {
        if(size == 0) throw new NoSuchElementException();
    }

    public Item sample() {
        return items[StdRandom.uniform(size)];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }

        items = copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    class RandomIterator implements Iterator<Item> {
        private Item[] randItems;
        private int i = size;

        RandomIterator() {
            randItems = (Item[]) new Object[size];
            for (int k = 0; k < size; k++) {
                randItems[k] = items[k];
            }
            StdRandom.shuffle(randItems);
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            assertNoneEmpty(i);
            return randItems[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();

        for (int i = 0; i < 4000000; i++) {
            q.enqueue(i);
        }

        StdOut.println(q.sample());
        StdOut.println(q.dequeue());
        StdOut.printf("size: %d\n", q.size());
        int sum = 0;
        for (Integer k : q) {
            sum += k;
        }
        StdOut.printf("sum: %d", sum);
        StdOut.println();
    }
}
