package com.chenleon.collection;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        while (k-- > 0) {
            String s = StdIn.readString();
            queue.enqueue(s);
        }

        for (String s : queue) {
            StdOut.println(s);
        }
    }
}
