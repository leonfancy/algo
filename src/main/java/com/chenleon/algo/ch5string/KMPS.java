package com.chenleon.algo.ch5string;

public class KMPS {
    public static int R = 256;

    public static int search(String s, String p) {
        int[][] dfa = dfa(p);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            j = dfa[s.charAt(i)][j];
            if(j == p.length()) return i - j + 1;
        }
        return -1;
    }

    public static int[][] dfa(String p) {
        int[][] dfa = new int[R][p.length()];
        int x = 0;

        dfa[p.charAt(0)][0] = 1;

        for (int j = 1; j < p.length(); j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x];
            dfa[p.charAt(j)][j] = j + 1;
            x = dfa[p.charAt(j)][x];
        }

        return dfa;
    }
}
