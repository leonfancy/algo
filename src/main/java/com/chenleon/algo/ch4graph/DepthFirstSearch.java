package com.chenleon.algo.ch4graph;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count = 0;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        count++;
        for (Integer v : G.adj(s))
            if (!marked[v]) dfs(G, v);
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
