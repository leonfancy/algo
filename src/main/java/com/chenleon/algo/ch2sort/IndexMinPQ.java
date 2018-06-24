package com.chenleon.algo.ch2sort;

public class IndexMinPQ<Key extends Comparable<Key>> {
    private Key[] keys;
    private int[] pq;
    private int[] qp;
    private int n;

    public IndexMinPQ(int maxN) {
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
    }

    public void insert(int i, Key v) {
        keys[i] = v;
        n++;
        pq[n] = i;
        qp[i] = n;
        swim(n);
    }

    public void changeKey(int i, Key key) {
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public int delMin() {
        int min = pq[1];
        exch(1, n--);
        sink(1);

        keys[min] = null;
        qp[min] = -1;
        pq[n +1] = -1;
        return min;
    }

    boolean isEmpty() {
        return n == 0;
    }

    int size() {
        return n;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j + 1, j)) j++;
            if (less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        int swp = pq[i];
        pq[i] = pq[j];
        pq[j] = swp;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
}
