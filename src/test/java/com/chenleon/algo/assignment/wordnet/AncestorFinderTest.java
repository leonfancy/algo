package com.chenleon.algo.assignment.wordnet;

import edu.princeton.cs.algs4.Digraph;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class AncestorFinderTest {
    @Test
    public void testAncestorFind() {
        Digraph G = new Digraph(5);
        G.addEdge(2, 1);
        G.addEdge(1, 0);
        G.addEdge(1, 3);
        G.addEdge(4, 0);

        AncestorFinder finder = new AncestorFinder(G, 2, 4);

        assertEquals(3, finder.length());
        assertEquals(0, finder.ancestor());

        finder = new AncestorFinder(G, 2, 1);

        assertEquals(1, finder.length());
        assertEquals(1, finder.ancestor());

        finder = new AncestorFinder(G, 2, 2);
        assertEquals(0, finder.length());
        assertEquals(2, finder.ancestor());

        finder = new AncestorFinder(G, 3, 0);
        assertEquals(-1, finder.length());
        assertEquals(-1, finder.ancestor());
    }

    @Test
    public void testAncestorFindWithMultiSource() {
        Digraph G = new Digraph(5);
        G.addEdge(2, 1);
        G.addEdge(1, 0);
        G.addEdge(3, 1);
        G.addEdge(4, 0);

        AncestorFinder finder = new AncestorFinder(G, asList(2), asList(4, 3));

        assertEquals(2, finder.length());
        assertEquals(1, finder.ancestor());
    }
}