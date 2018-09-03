package com.chenleon.algo.ch5string;

import org.junit.Test;

import static org.junit.Assert.*;

public class KMPSTest {
    @Test
    public void testSearch() {
        assertEquals(0, KMPS.search("AABB", "AA"));
        assertEquals(1, KMPS.search("BAABB", "AA"));
        assertEquals(1, KMPS.search("BAABB", "AABB"));
        assertEquals(0, KMPS.search("AA", "AA"));
        assertEquals(0, KMPS.search("A", "A"));
    }
}