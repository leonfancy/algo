package com.chenleon.algo.ch4graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.MinPQ;

public class LazyPrimMST {
    private Bag<Edge> mst;
    private boolean[] marked;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        mst = new Bag<>();
        pq = new MinPQ<>();
        marked = new boolean[G.V()];

        visit(G, 0);

        while (mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);

            if (marked[v] && marked[w]) continue;

            mst.add(e);
            if (marked[v]) visit(G, w);
            if (marked[w]) visit(G, v);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0;
        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v))
            if (!marked[e.other(v)])
                pq.insert(e);
    }
}
