package com.chenleon.algo.ch4graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class KaosarajuSCCTest {

    @Test
    public void testSCC() {
        Digraph graph = new Digraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(0, 2);
        graph.addEdge(3, 0);

        KaosarajuSCC scc = new KaosarajuSCC(graph);

        assertTrue(scc.stronglyConnected(1, 2));
        assertTrue(scc.stronglyConnected(0, 2));
        assertTrue(scc.stronglyConnected(0, 1));
        assertFalse(scc.stronglyConnected(0, 3));
        assertFalse(scc.stronglyConnected(1, 3));
        assertFalse(scc.stronglyConnected(0, 4));

        assertEquals(3, scc.count());
    }
}