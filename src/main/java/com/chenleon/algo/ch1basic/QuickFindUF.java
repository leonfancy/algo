package com.chenleon.algo.ch1basic;

public class QuickFindUF {
    private int count;
    private int[] ids;

    public QuickFindUF(int count) {
        ids = new int[count];
        for (int i = 0; i < count; i++) {
            ids[i] = i;
        }

        this.count = count;
    }

    public void union(int p, int q)
    {
        int pid = ids[p];
        int qid = ids[q];
        for (int i = 0; i < count; i++) {
            if(ids[i] == qid) ids[i] = pid;
        }
    }

    public int find(int p) {
        return ids[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return count;
    }
}
