package com.chenleon.algo.ch1basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickFindUFTest {
    @Test
    public void testUnionAndConnected() {
        QuickFindUF uf = new QuickFindUF(10);
        uf.union(0, 1);
        uf.union(6, 9);
        uf.union(6, 1);
        assertTrue(uf.connected(0, 6));
        assertTrue(uf.connected(1, 9));
        assertFalse(uf.connected(1, 8));
    }
}