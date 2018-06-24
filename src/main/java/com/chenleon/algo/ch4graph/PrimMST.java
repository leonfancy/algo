package com.chenleon.algo.ch4graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;

public class PrimMST {
    private boolean[] marked;
    private Edge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        distTo = new double[G.V()];
        edgeTo = new Edge[G.V()];
        pq = new IndexMinPQ<>(G.V());

        for (int i = 0; i < G.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;

        distTo[0] = 0.0;
        pq.insert(0, 0.0);

        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);

            if (marked[w]) continue;

            if (distTo[w] > e.weight()) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        Bag<Edge> edges = new Bag<>();
        for (int v = 1; v < edgeTo.length; v++) {
            edges.add(edgeTo[1]);
        }
        return edges;
    }

    public double weight() {
        double weight = 0.0;
        for (int i = 1; i < distTo.length; i++) {
            weight += distTo[i];
        }
        return weight;
    }
}
