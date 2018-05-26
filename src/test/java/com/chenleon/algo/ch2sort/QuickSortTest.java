package com.chenleon.algo.ch2sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        Integer[] a = {3, 6, 9, 1, 7, 8, 4, 5};
        QuickSort.sort(a);
        assertEquals(true, QuickSort.isSorted(a));
    }
}