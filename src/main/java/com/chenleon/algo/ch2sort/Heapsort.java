package com.chenleon.algo.ch2sort;

import edu.princeton.cs.algs4.In;

public class Heapsort extends AbstractSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exchange(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) j++;
            if (less(a, j, k)) break;
            exchange(a, k, j);
            k = j;
        }
    }

    protected static boolean less(Comparable a[], int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    protected static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        show(a);
        sort(a);
        if (isSorted(a)) {
            System.out.println("Ordered");
        }
        show(a);
    }
}
