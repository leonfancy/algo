package com.chenleon.algo.ch5string;

public class KMP {
    public static int search(String text, String pattern) {
        int[] next = findNext(pattern);

        int plen = pattern.length(), tlen = text.length();
        int i = 0, j = 0;

        while (i < tlen && j < plen) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) i++;
                else j = next[j];
            }
        }

        return j == plen ? i - j : -1;
    }

    public static int[] findNext(String p) {
        int len = p.length();

        int next[] = new int[len];

        next[0] = -1;
        int i = 0;
        int k = -1;

        while (i < len - 1) {
            if (k == -1 || p.charAt(k) == p.charAt(i)) {
                next[i + 1] = k + 1;
                k = next[++i];
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
