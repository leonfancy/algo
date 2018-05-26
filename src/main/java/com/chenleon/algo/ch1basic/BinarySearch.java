package com.chenleon.algo.ch1basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int mid, lo = 0, hi = a.length;
        while (hi >= lo) {
            mid = (hi + lo) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key < a[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty())
        {

            int key = StdIn.readInt();
            StdOut.println("loop");
            if(rank(key, whitelist) < 0)
                StdOut.println(key);
        }

    }
}
