package com.chenleon.algo.ch2sort;

public class Quick3way extends AbstractSort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;

        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];

        while (i <= gt) {
            int res = a[i].compareTo(v);
            if (res < 0) exchange(a, i++, lt++);
            else if (res > 0) exchange(a, i, gt--);
            else i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
