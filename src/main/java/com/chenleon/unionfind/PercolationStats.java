package com.chenleon.unionfind;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] p;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Illegal n and trials");

        p = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                if (!percolation.isOpen(row, col))
                    percolation.open(row, col);
            }
            p[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
    }

    public double mean() {
        return StdStats.mean(p);
    }

    public double stddev() {
        return StdStats.stddev(p);
    }

    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(p.length);
    }

    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(p.length);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(n, T);

        StdOut.printf("mean                     = %f\n", percolationStats.mean());
        StdOut.printf("stddev                   = %f\n", percolationStats.stddev());
        StdOut.printf("95%% confidence Interval  = [%f, %f]\n",
                percolationStats.confidenceLo(), percolationStats.confidenceHi());

    }
}
