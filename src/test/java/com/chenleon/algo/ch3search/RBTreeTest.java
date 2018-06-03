package com.chenleon.algo.ch3search;

import org.junit.Test;

import static org.junit.Assert.*;

public class RBTreeTest {
    @Test
    public void testGetAndPut() {
        RBTree<Integer, String> tree = new RBTree<>();
        tree.put(4, "A");
        tree.put(3, "B");
        tree.put(2, "C");

        assertEquals("C", tree.get(2));
        assertEquals(3, tree.size());
    }
}