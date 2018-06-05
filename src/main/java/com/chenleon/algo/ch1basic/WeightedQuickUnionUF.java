package com.chenleon.algo.ch1basic;

public class WeightedQuickUnionUF {
    private int count;
    private int[] parent;
    private int[] sz;

    public WeightedQuickUnionUF(int count) {
        parent = new int[count];
        sz = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
        }

        this.count = count;
    }

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (sz[pid] > sz[qid]) {
            parent[qid] = parent[pid];
            sz[pid] += sz[qid];
        } else {
            parent[pid] = parent[qid];
            sz[qid] += sz[pid];
        }
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
        str.append("\n");
        return str.toString();
    }
}
