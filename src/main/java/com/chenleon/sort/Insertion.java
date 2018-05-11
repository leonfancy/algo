package com.chenleon.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Insertion extends AbstractSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 1; i < N; i++) {
           for(int j = i; j > 0 && less(a[j], a[j-1]); j--)  {
               exchange(a, j, j-1);
           }
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        show(a);
        sort(a);
        if (!isSorted(a)) {
            StdOut.println("NOT sorted!!");
        } else {
            show(a);
        }
    }
}
