package com.chenleon.algo.ch4graph;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GraphTest {
    @Test
    public void testBasicAPI() {
        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(7, 9);
        graph.addEdge(8, 9);

        assertEquals(3, graph.E());
        assertEquals(10, graph.V());

        Set<Integer> adj = new HashSet<>();

        for (Integer o : graph.adj(9)) {
            adj.add(o);
        }

        assertArrayEquals(new Integer[]{7, 8}, adj.toArray());
    }
}