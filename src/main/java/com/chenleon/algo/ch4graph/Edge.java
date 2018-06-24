package com.chenleon.algo.ch4graph;

public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    double weight() {
        return weight;
    }

    int either() {
        return v;
    }

    int other(int vertex) {
        if(v == vertex) return w;
        else if(w == vertex) return v;
        else throw new IllegalArgumentException("Invalid vertex");
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
