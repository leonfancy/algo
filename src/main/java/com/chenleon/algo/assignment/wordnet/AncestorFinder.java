package com.chenleon.algo.assignment.wordnet;

import edu.princeton.cs.algs4.Digraph;

import java.util.Collections;
import java.util.LinkedList;

public class AncestorFinder {
    private int length = -1;
    private int ancestor = -1;

    public AncestorFinder(Digraph G, int v, int w) {
        this(G, Collections.singletonList(v), Collections.singletonList(w));
    }

    public AncestorFinder(Digraph G, Iterable<Integer> v, Iterable<Integer> w) {
        boolean[] vMarked = new boolean[G.V()];
        int[] vDistTo = new int[G.V()];

        boolean[] wMarked = new boolean[G.V()];
        int[] wDistTo = new int[G.V()];

        LinkedList<Integer> q = new LinkedList<>();

        for (Integer s : v) {
            q.add(s);
            vMarked[s] = true;
            vDistTo[s] = 0;
        }

        while (!q.isEmpty()) {
            Integer k = q.remove();
            for (Integer t : G.adj(k)) {
                if (!vMarked[t]) {
                    vMarked[t] = true;
                    q.add(t);
                    vDistTo[t] = vDistTo[k] + 1;
                }
            }
        }

        for (Integer s : w) {
            q.add(s);
            wMarked[s] = true;
            wDistTo[s] = 0;
        }

        while (!q.isEmpty()) {
            Integer k = q.remove();

            if (vMarked[k]) {
                if (length == -1 || (vDistTo[k] + wDistTo[k]) < length) {
                    length = vDistTo[k] + wDistTo[k];
                    ancestor = k;
                }
            }

            for (Integer t : G.adj(k)) {
                if (!wMarked[t]) {
                    wMarked[t] = true;
                    q.add(t);
                    wDistTo[t] = wDistTo[k] + 1;
                }
            }
        }
    }

    public int length() {
        return length;
    }

    public int ancestor() {
        return ancestor;
    }
}
