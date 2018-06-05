package com.chenleon.algo.ch1basic;

public class QuickUnionUF {
    private int count;
    private int[] parent;

    public QuickUnionUF(int count) {
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }

        this.count = count;
    }

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        parent[pid] = parent[qid];
    }

    public int find(int p) {
        while (p != parent[p]) p = parent[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < count; i++) {
            str.append(i).append(" ");
        }
        str.append("\n");
        for (int i = 0; i < count; i++) {
            str.append(parent[i]).append(" ");
        }
        return str.toString();
    }
}
