package com.chenleon.algo.ch4graph;

import com.chenleon.algo.ch1basic.Stack;

public class DirectedCycle {
    private boolean[] onStack;
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph G) {
        cycle = new Stack<>();
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (Integer w : G.adj(v)) {
            if (hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle.push(w);
                for (int k = v; k != w; k = edgeTo[k])
                    cycle.push(k);
                cycle.push(w);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return !cycle.isEmpty();
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
