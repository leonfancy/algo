package com.chenleon.algo.ch5string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LSDTest {
    @Test
    public void shouldSortStringWithSameLength() {
        String[] a = {"3DYE230", "3CI0740", "3CI0730"};

        LSD.sort(a, 7);

        String[] expected = {"3CI0730", "3CI0740", "3DYE230"};
        assertArrayEquals(expected, a);
    }
}