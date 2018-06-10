package com.chenleon.algo.ch4graph;

public class DirectedDFS {
    private boolean[] marked;
    private int count;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        count++;
        for (Integer w : G.adj(v)) {
            if(!marked[w]) dfs(G, w);
        }
    }

    public boolean visited(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
