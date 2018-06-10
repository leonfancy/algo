package com.chenleon.algo.ch4graph;

import java.util.LinkedList;

public class NonRecursiveDFS {
    private boolean[] marked;
    private int count = 0;
    private LinkedList<Integer> stack;

    public NonRecursiveDFS(Graph G, int s) {
        marked = new boolean[G.V()];
        stack = new LinkedList<>();
        stack.push(s);

        while (!stack.isEmpty()) {
            Integer v = stack.pop();

            if (!marked[v]) {
                marked[v] = true;
                count++;

                for (Integer w : G.adj(v))
                    stack.push(w);
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
