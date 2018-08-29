package com.chenleon.algo.ch5string;

import edu.princeton.cs.algs4.Alphabet;

public class MSD {
    private static int R;
    private static Alphabet alpha;
    private static String[] aux;

    public static void sort(String[] arr, Alphabet alphabet) {
        R = alphabet.radix();
        alpha = alphabet;
        int N = arr.length;
        aux = new String[N];
        sort(arr, 0, N - 1, 0);
    }

    private static void sort(String[] arr, int lo, int hi, int d) {
        if (hi <= lo) return;

        int[] count = new int[R + 2];

        for (int i = lo; i <= hi; i++)
            count[charAt(arr[i], d) + 2]++;

        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];

        for (int i = lo; i <= hi; i++)
            aux[count[charAt(arr[i], d) + 1]++] = arr[i];

        for (int i = lo; i <= hi; i++)
            arr[i] = aux[i - lo];

        for (int r = 0; r < R; r++)
            sort(arr, lo + count[r], lo + count[r + 1] - 1, d + 1);
    }

    private static int charAt(String s, int d) {
        return d < s.length() ? alpha.toIndex(s.charAt(d)) : -1;
    }
}
