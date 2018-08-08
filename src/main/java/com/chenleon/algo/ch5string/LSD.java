package com.chenleon.algo.ch5string;

import static java.lang.System.arraycopy;

public class LSD {
    public static void sort(String[] arr, int W) {
        int N = arr.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            for (String e : arr)
                count[e.charAt(d) + 1]++;

            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];

            for (String e : arr)
                aux[count[e.charAt(d)]++] = e;

            arraycopy(aux, 0, arr, 0, N);
        }
    }
}
