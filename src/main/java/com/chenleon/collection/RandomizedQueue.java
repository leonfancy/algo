package com.chenleon.collection;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<T> implements Iterable<T> {
    private T[] items;
    private int size = 0;

    public RandomizedQueue() {
        items = (T[]) new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        if (item == null) throw new IllegalArgumentException("item must not be null");
        if (size == items.length) resize(2 * size);
        items[size++] = item;
    }

    public T dequeue() {
        assertNoneEmpty(size);
        int index = StdRandom.uniform(size);
        T item = items[index];
        items[index] = items[--size]; // move the last item to target place
        items[size] = null;
        if (size > 0 && size == items.length / 4) resize(items.length / 2);
        return item;
    }

    private void assertNoneEmpty(int size) {
        if(size == 0) throw new NoSuchElementException();
    }

    public T sample() {
        return items[StdRandom.uniform(size)];
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }

        items = copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomIterator();
    }

    class RandomIterator implements Iterator<T> {
        private T[] randItems;
        private int i = size;

        RandomIterator() {
            randItems = (T[]) new Object[size];
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
        public T next() {
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