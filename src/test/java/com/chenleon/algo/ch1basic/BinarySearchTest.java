package com.chenleon.algo.ch1basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void shouldFindCorrectKey() {
        int[] a = {1, 4, 5, 9};

        assertEquals(1, BinarySearch.rank(4, a));
        assertEquals(0, BinarySearch.rank(1, a));
        assertEquals(3, BinarySearch.rank(9, a));
    }

    @Test
    public void shouldReturnMinusOneIfKeyCannotBeFound() {
        int[] a = {1, 4, 5, 9};

        assertEquals(-1, BinarySearch.rank(8, a));
    }
}