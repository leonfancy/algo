package com.chenleon.algo.assignment.eightpuzzle;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void shouldGiveCorrectHamming() {
        int[][] blocks = {
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}
        };
        Board board = new Board(blocks);
        assertEquals(5, board.hamming());
    }

    @Test
    public void shouldGiveCorrectManhattan() {
        int[][] blocks = {
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}
        };
        Board board = new Board(blocks);
        assertEquals(10, board.manhattan());
    }

    @Test
    public void shouldGiveCorrectManhattan2x2() {
        int[][] blocks = {
                {1, 3},
                {0, 2}
        };
        Board board = new Board(blocks);
        assertEquals(3, board.manhattan());
    }

    @Test
    public void shouldGiveCorrectManhattan3x3() {
        int[][] blocks = {
                {0, 1, 3},
                {4, 2, 5},
                {7, 8, 6}
        };
        Board board = new Board(blocks);
        assertEquals(4, board.manhattan());
    }

    @Test
    public void shouldEquals() {
        int[][] blocks = {
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}
        };
        Board a = new Board(blocks);
        Board b = new Board(blocks);

        assertEquals(a, b);
    }

    @Test
    public void shouldFindNeighbors() {
        Board board = new Board(new int[][]{
                {8, 1, 3},
                {4, 2, 0},
                {7, 6, 5}
        });

        Iterable<Board> neighbors = board.neighbors();

        Board up = new Board(new int[][]{
                {8, 1, 0},
                {4, 2, 3},
                {7, 6, 5}
        });
        Board left = new Board(new int[][]{
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}
        });

        Board down = new Board(new int[][]{
                {8, 1, 3},
                {4, 2, 5},
                {7, 6, 0}
        });

        assertThat(neighbors, CoreMatchers.hasItem(up));
        assertThat(neighbors, CoreMatchers.hasItem(left));
        assertThat(neighbors, CoreMatchers.hasItem(down));
        assertEquals(3, ((Collection)neighbors).size());
    }

    @Test
    public void testToString() {
        Board board = new Board(new int[][]{
                {8, 1, 3},
                {4, 2, 0},
                {7, 6, 5}
        });
        System.out.print(board);
    }
}