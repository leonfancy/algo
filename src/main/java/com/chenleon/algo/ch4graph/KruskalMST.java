package com.chenleon.algo.ch4graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;

public class KruskalMST {
    private Bag<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        MinPQ<Edge> pq = new MinPQ<>();
        mst = new Bag<>();
        UF uf = new UF(G.V());

        for (Edge edge : G.edges()) {
            pq.insert(edge);
        }

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);

            if(uf.connected(v, w)) continue;

            mst.add(e);
            uf.union(v, w);
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
}
