package com.chenleon.sort;

public class QuickSort extends AbstractSort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;

        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo]))
                if (i >= hi) break;
            while (less(a[lo], a[--j]))
                if (j <= lo) break;

            if (i >= j) break;

            exchange(a, i, j);
        }

        exchange(a, lo, j);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
}
