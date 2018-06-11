package com.chenleon.algo.ch4graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectedCycleTest {
    @Test
    public void testCycle() {
        Digraph graph = new Digraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(3, 0);

        DirectedCycle cycle = new DirectedCycle(graph);

        assertTrue(cycle.hasCycle());
    }
}