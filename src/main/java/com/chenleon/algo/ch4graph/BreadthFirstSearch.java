package com.chenleon.algo.ch4graph;

import java.util.LinkedList;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int count = 0;
    private LinkedList<Integer> q;

    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        count++;

        while (!q.isEmpty()) {
            Integer v = q.remove();
            for (Integer w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    count++;
                    q.add(w);
                }
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
