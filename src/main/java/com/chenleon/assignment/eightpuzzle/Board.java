package com.chenleon.assignment.eightpuzzle;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private char[] blocks;
    private int hamming = -1;
    private int manhattan = -1;
    private int n;

    public Board(int[][] blocks) {
        n = blocks.length;
        this.blocks = new char[n * n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                this.blocks[i * n + j] = (char) blocks[i][j];
    }

    public int dimension() {
        return n;
    }

    public int hamming() {
        if (hamming != -1) return hamming;

        hamming = 0;
        for (int i = 1; i < n * n; i++)
            if (blocks[i - 1] != i) hamming++;
        return hamming;
    }

    public int manhattan() {
        if (manhattan != -1) return manhattan;

        manhattan = 0;
        for (int i = 0; i < n * n; i++) {
            if (blocks[i] != 0 && blocks[i] != i + 1) {
                int a = Math.abs((blocks[i] - 1)/n - i/n);
                int b = Math.abs((blocks[i] - 1)%n - i%n);
                manhattan += (a + b);
            }
        }
        return manhattan;
    }

    public boolean isGoal() {
        return hamming() == 0 || manhattan() == 0;
    }

    public Board twin() {
        int[][] twin = new int[n][n];

        for (int i = 0; i < n * n; i++) {
            twin[i / n][i % n] = blocks[i];
        }

        if (blocks[0] == 0) exchange(twin, 1, 2);
        else if (blocks[1] == 0) exchange(twin, 0, 2);
        else exchange(twin, 0, 1);

        return new Board(twin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.equals(blocks, board.blocks);
    }

    public Iterable<Board> neighbors() {
        ArrayList<Board> neighbors = new ArrayList<>();

        int zi = -1;
        int[][] copy = new int[n][n];
        for (int i = 0; i < n * n; i++) {
            if (blocks[i] == 0) zi = i;
            copy[i / n][i % n] = blocks[i];
        }

        if (zi - n >= 0) {
            exchange(copy, zi, zi - n);
            neighbors.add(new Board(copy));
            exchange(copy, zi, zi - n);
        }

        if (zi + n < n * n) {
            exchange(copy, zi, zi + n);
            neighbors.add(new Board(copy));
            exchange(copy, zi, zi + n);
        }


        if (zi % n > 0) {
            exchange(copy, zi, zi - 1);
            neighbors.add(new Board(copy));
            exchange(copy, zi, zi - 1);
        }

        if (zi % n < n - 1) {
            exchange(copy, zi, zi + 1);
            neighbors.add(new Board(copy));
            exchange(copy, zi, zi + 1);
        }

        return neighbors;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n).append("\n");
        for (int i = 0; i < n * n; i++) {
            s.append(String.format("%2d ", (int) blocks[i]));
            if (i % n == n - 1) s.append("\n");
        }
        return s.toString();
    }

    private void exchange(int[][] blocks, int i, int j) {
        int t = blocks[i / n][i % n];
        blocks[i / n][i % n] = blocks[j / n][j % n];
        blocks[j / n][j % n] = t;
    }
}
