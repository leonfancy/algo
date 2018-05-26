package com.chenleon.algo.ch3search;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {
    @Test
    public void testPutAndGet() {
        BST<String, Integer> bst = new BST<>();
        bst.put("S", 1);
        bst.put("E", 2);
        bst.put("X", 3);
        assertEquals(1, bst.get("S").intValue());
        assertEquals(2, bst.get("E").intValue());
        assertEquals(3, bst.get("X").intValue());
    }

    @Test
    public void testFloor() {
        BST<String, Integer> bst = new BST<>();
        bst.put("S", 1);
        bst.put("E", 2);
        bst.put("X", 3);
        bst.put("A", 4);
        bst.put("R", 5);
        bst.put("H", 6);
        assertEquals(2, bst.floor("G").intValue());
        assertEquals(6, bst.floor("H").intValue());
        assertEquals(3, bst.floor("Z").intValue());
    }
}