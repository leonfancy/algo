package com.chenleon.algo.assignment.wordnet;

import edu.princeton.cs.algs4.Digraph;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SAPTest {
    private Digraph G;
    @Before
    public void setUp() throws Exception {
        G = new Digraph(25);
        G.addEdge(1, 0);
        G.addEdge(2, 0);
        G.addEdge(3, 1);
        G.addEdge(4, 1);
        G.addEdge(5, 2);
        G.addEdge(6, 2);
        G.addEdge(7, 3);
        G.addEdge(8, 3);
        G.addEdge(9, 3);
        G.addEdge(10, 5);
        G.addEdge(11, 5);
        G.addEdge(12, 5);
        G.addEdge(13, 7);
        G.addEdge(14, 7);
        G.addEdge(15, 9);
        G.addEdge(16, 9);
        G.addEdge(17, 10);
        G.addEdge(18, 10);
        G.addEdge(19, 12);
        G.addEdge(20, 12);
        G.addEdge(21, 16);
        G.addEdge(22, 16);
        G.addEdge(23, 20);
        G.addEdge(24, 20);
    }

    @Test
    public void testSap() {
        SAP sap = new SAP(G);
        assertEquals(4, sap.length(13, 16));
        assertEquals(3, sap.ancestor(13, 16));

        assertEquals(4, sap.length(Arrays.asList(13, 23, 24), Arrays.asList(6, 16, 17)));
        assertEquals(3, sap.ancestor(Arrays.asList(13, 23, 24), Arrays.asList(6, 16, 17)));
    }

    @Test
    public void testSapWithMultiplePathToSameAncestor() {
        Digraph digraph = new Digraph(6);
        digraph.addEdge(1, 0);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 4);
        digraph.addEdge(4, 5);
        digraph.addEdge(5, 0);

        SAP sap = new SAP(digraph);
        assertEquals(2, sap.length(3, 1));
    }
}