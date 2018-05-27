package com.chenleon.algo.ch3search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {
    private BST<String, Integer> bst;

    @Before
    public void setUp() throws Exception {
        bst = new BST<>();

        bst.put("S", 1);
        bst.put("E", 2);
        bst.put("X", 3);
        bst.put("A", 4);
        bst.put("R", 5);
        bst.put("C", 6);
        bst.put("H", 7);
        bst.put("M", 8);
    }

    @Test
    public void testGet() {
        assertEquals(1, bst.get("S").intValue());
        assertEquals(2, bst.get("E").intValue());
        assertEquals(3, bst.get("X").intValue());
    }

    @Test
    public void testFloor() {
        assertEquals(2, bst.floor("G").intValue());
        assertEquals(7, bst.floor("H").intValue());
        assertEquals(3, bst.floor("Z").intValue());
    }

    @Test
    public void testCeil() {
        assertEquals(7, bst.ceil("G").intValue());
        assertEquals(7, bst.ceil("H").intValue());
        assertNull(bst.ceil("Z"));
    }

    @Test
    public void testMin() {
        assertEquals(4, bst.min().intValue());
    }

    @Test
    public void testMax() {
        assertEquals(3, bst.max().intValue());
    }

    @Test
    public void testSize() {
        assertEquals(8, bst.size());
    }

    @Test
    public void testRank() {
        assertEquals(1, bst.rank("B"));
        assertEquals(8, bst.rank("Z"));
        assertEquals(1, bst.rank("C"));
    }
}