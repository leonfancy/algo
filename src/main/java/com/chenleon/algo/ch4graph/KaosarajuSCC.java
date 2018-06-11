package com.chenleon.algo.ch4graph;

public class KaosarajuSCC {
    private boolean[] marked;
    private int count;
    private int[] id;

    public KaosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];

        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for (int v : order.reversePost()) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (Integer w : G.adj(v))
            if (!marked[w]) dfs(G, w);
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
