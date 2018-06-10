package com.chenleon.algo.ch4graph;

import java.util.LinkedList;

public class DirectedBFS {
    private boolean[] marked;
    private LinkedList<Integer> queue;
    private int count;

    public DirectedBFS(Graph G, int s) {
        marked = new boolean[G.V()];
        queue = new LinkedList<>();

        marked[s] = true;
        count++;
        queue.add(s);

        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            for (Integer w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    queue.add(w);
                    count++;
                }
            }
        }
    }

    public boolean visited(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
