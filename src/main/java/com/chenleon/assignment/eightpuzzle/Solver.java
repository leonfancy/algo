package com.chenleon.assignment.eightpuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;
import java.util.LinkedList;

public class Solver {
    private LinkedList<Board> steps = new LinkedList<>();
    private boolean isSolvable;

    public Solver(Board initial) {
        MinPQ<SearchNode> pq = new MinPQ<>(manComparator());
        MinPQ<SearchNode> twinPq = new MinPQ<>(manComparator());

        pq.insert(new SearchNode(null, initial, 0));
        twinPq.insert(new SearchNode(null, initial.twin(), 0));

        boolean isOrigin = true;
        isSolvable = false;
        while (true) {
            MinPQ<SearchNode> q = isOrigin ? pq : twinPq;

            SearchNode currentNode = q.delMin();

            if (currentNode.board.isGoal()) {
                if (isOrigin) {
                    isSolvable = true;
                    SearchNode p = currentNode;
                    while (p != null) {
                        steps.addFirst(p.board);
                        p = p.prev;
                    }
                }
                break;
            }

            for (Board neighbor : currentNode.board.neighbors()) {
                if (currentNode.prev == null || !neighbor.equals(currentNode.prev.board))
                    q.insert(new SearchNode(currentNode, neighbor, currentNode.moves + 1));
            }

            isOrigin = !isOrigin;
        }
    }

    public boolean isSolvable() {
        return isSolvable;
    }

    public int moves() {
        return steps.size() - 1;
    }

    public Iterable<Board> solution() {
        return steps;
    }

    private Comparator<SearchNode> hamComparator() {
        return new Comparator<SearchNode>() {
            @Override
            public int compare(SearchNode o1, SearchNode o2) {
                return o1.hamPriority() - o2.hamPriority();
            }
        };
    }

    private Comparator<SearchNode> manComparator() {
        return new Comparator<SearchNode>() {
            @Override
            public int compare(SearchNode o1, SearchNode o2) {
                int res = o1.manPriority() - o2.manPriority();
                return res == 0 ? o1.board.manhattan() - o2.board.manhattan() : res;
            }
        };
    }

    class SearchNode {
        Board board;
        int moves;
        SearchNode prev;

        public SearchNode(SearchNode prev, Board board, int moves) {
            this.prev = prev;
            this.board = board;
            this.moves = moves;
        }

        public int hamPriority() {
            return board.hamming() + moves;
        }

        public int manPriority() {
            return board.manhattan() + moves;
        }
    }

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
