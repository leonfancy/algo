package com.chenleon.unionfind;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] sites;
    private int N;
    private WeightedQuickUnionUF uf, auxUf;
    private int openSitesCount;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be more than 0");

        N = n;
        sites = new boolean[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                sites[i][j] = false;

        uf = new WeightedQuickUnionUF(N * N + 1);
        auxUf = new WeightedQuickUnionUF(N * N + 2);
    }

    public void open(int row, int col) {
        validate(row);
        validate(col);

        row -= 1;
        col -= 1;

        sites[row][col] = true;
        openSitesCount++;

        if (row > 0 && sites[row - 1][col]) {
            uf.union((row - 1) * N + col, row * N + col);
            auxUf.union((row - 1) * N + col, row * N + col);
        }

        if (row < N - 1 && sites[row + 1][col]) {
            uf.union((row + 1) * N + col, row * N + col);
            auxUf.union((row + 1) * N + col, row * N + col);
        }

        if (col > 0 && sites[row][col - 1]) {
            uf.union(row * N + col - 1, row * N + col);
            auxUf.union(row * N + col - 1, row * N + col);
        }

        if (col < N - 1 && sites[row][col + 1]) {
            uf.union(row * N + col + 1, row * N + col);
            auxUf.union(row * N + col + 1, row * N + col);
        }

        if (row == 0) {
            uf.union(N * N, row * N + col);
            auxUf.union(N * N, row * N + col);
        }
        if (row == N - 1) auxUf.union(N * N + 1, row * N + col);
    }

    public boolean isOpen(int row, int col) {
        validate(row);
        validate(col);
        return sites[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        validate(row);
        validate(col);
        return uf.connected(N * N, (row - 1) * N + col - 1);
    }

    public int numberOfOpenSites() {
        return openSitesCount;
    }

    public boolean percolates() {
        return auxUf.connected(N * N, N * N + 1);
    }

    private void validate(int i) {
        if (!(i >= 1 && i <= N)) throw new IllegalArgumentException("Invalid params");
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(2, 2);
        percolation.open(2, 3);
        percolation.open(3, 1);
        percolation.open(3, 3);

        StdOut.printf("%d open sites\n", percolation.numberOfOpenSites());
        StdOut.printf("percolates: %s\n", percolation.percolates() ? "yes" : "no");
        StdOut.printf("is (3,1) full: %s\n", percolation.isFull(3, 1));
    }
}
