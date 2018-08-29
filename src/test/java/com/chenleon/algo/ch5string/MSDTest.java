package com.chenleon.algo.ch5string;

import edu.princeton.cs.algs4.Alphabet;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MSDTest {
    @Test
    public void shouldSortStringWithVariableLength() {
        String[] a = {"shell", "shall", "she", "she"};

        MSD.sort(a, Alphabet.LOWERCASE);

        String[] expected = {"shall", "she", "she", "shell"};

        assertArrayEquals(expected, a);
    }
}