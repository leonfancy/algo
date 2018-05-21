package com.chenleon.sort;

import org.junit.Test;
import static org.junit.Assert.*;

public class Quick3wayTest {
    @Test
    public void testQuick3waySort() {
        Integer[] a = {3, 6, 9, 1, 7, 8, 4, 5, 5, 9, 9};
        Quick3way.sort(a);
        assertEquals(true, Quick3way.isSorted(a));
    }
}