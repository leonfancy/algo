package com.chenleon.algo.ch1basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeightedQuickUnionUFTest {
    @Test
    public void name() {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
        uf.union(0, 1);
        System.out.println(uf);
        uf.union(1, 2);
        System.out.println(uf);
        uf.union(6, 9);
        System.out.println(uf);
        uf.union(6, 1);
        System.out.println(uf);

        assertTrue(uf.connected(0, 6));
        assertTrue(uf.connected(1, 9));
        assertFalse(uf.connected(1, 8));
    }

}