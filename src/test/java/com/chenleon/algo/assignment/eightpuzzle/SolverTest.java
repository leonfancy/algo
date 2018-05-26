package com.chenleon.algo.assignment.eightpuzzle;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolverTest {
    @Test
    public void solver() {
        int[][] blocks = {
                {1, 0, 2},
                {7, 5, 4},
                {8, 6, 3}
        };
        Board board = new Board(blocks);
        Solver solver = new Solver(board);
        assertEquals(11, solver.moves());
    }
}