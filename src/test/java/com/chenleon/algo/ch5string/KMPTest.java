package com.chenleon.algo.ch5string;

import org.junit.Test;

import static org.junit.Assert.*;

public class KMPTest {
    @Test
    public void testFindNext() {
        assertArrayEquals(new int[]{-1}, KMP.findNext("A"));
        assertArrayEquals(new int[]{-1, 0}, KMP.findNext("AA"));
        assertArrayEquals(new int[]{-1, 0, 1}, KMP.findNext("AAB"));
        assertArrayEquals(new int[]{-1, 0, 1, 0, 1}, KMP.findNext("AABAA"));
        assertArrayEquals(new int[]{-1, 0, 1, 0, 1, 2, 2}, KMP.findNext("AABAAAB"));
        assertArrayEquals(new int[]{-1, 0, 1, 2}, KMP.findNext("AAAA"));
    }

    @Test
    public void testSearch() {
        assertEquals(0, KMP.search("AABB", "AA"));
        assertEquals(1, KMP.search("BAABB", "AA"));
        assertEquals(1, KMP.search("BAABB", "AABB"));
        assertEquals(0, KMP.search("AA", "AA"));
        assertEquals(0, KMP.search("A", "A"));
    }
}