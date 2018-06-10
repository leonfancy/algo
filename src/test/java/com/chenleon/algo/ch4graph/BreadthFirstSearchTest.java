package com.chenleon.algo.ch4graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class BreadthFirstSearchTest {
    @Test
    public void testBFS() {
        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(7, 9);
        graph.addEdge(8, 9);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(6, 5);

        BreadthFirstSearch dfs = new BreadthFirstSearch(graph, 9);
        assertEquals(5, dfs.count());

        NonRecursiveDFS dfs2 = new NonRecursiveDFS(graph, 1);
        assertEquals(2, dfs2.count());
    }
}