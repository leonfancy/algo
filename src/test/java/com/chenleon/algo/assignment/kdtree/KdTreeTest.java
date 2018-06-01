package com.chenleon.algo.assignment.kdtree;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.Test;

import static org.junit.Assert.*;

public class KdTreeTest {
    @Test
    public void testInsertAndContain() {
        KdTree tree = new KdTree();
        tree.insert(new Point2D(0.1, 0.2));
        tree.insert(new Point2D(0.2, 0.3));
        assertTrue(tree.contains(new Point2D(0.1, 0.2)));
        assertFalse(tree.contains(new Point2D(0.1, 0.3)));
        assertEquals(2, tree.size());
    }

    @Test
    public void testDraw() {
        KdTree tree = new KdTree();
        tree.insert(new Point2D(0.7, 0.2));
        tree.insert(new Point2D(0.5, 0.4));
        tree.insert(new Point2D(0.2, 0.3));
        tree.insert(new Point2D(0.4, 0.7));
        tree.insert(new Point2D(0.9, 0.6));
        tree.draw();
    }

    @Test
    public void testNearest() {
        KdTree tree = new KdTree();
        tree.insert(new Point2D(0.7, 0.2));
        tree.insert(new Point2D(0.5, 0.4));
        tree.insert(new Point2D(0.2, 0.3));
        tree.insert(new Point2D(0.4, 0.7));
        tree.insert(new Point2D(0.9, 0.6));

        assertEquals(new Point2D(0.2, 0.3), tree.nearest(new Point2D(0.3, 0.3)));
    }

    @Test
    public void testRange() {
        KdTree tree = new KdTree();
        tree.insert(new Point2D(0.7, 0.2));
        tree.insert(new Point2D(0.5, 0.4));
        tree.insert(new Point2D(0.2, 0.3));
        tree.insert(new Point2D(0.4, 0.7));
        tree.insert(new Point2D(0.9, 0.6));

        RectHV rect = new RectHV(0.1, 0.1, 0.25, 0.35);

        Iterable<Point2D> points = tree.range(rect);
        for (Point2D point : points) {
            assertEquals(new Point2D(0.2, 0.3), point);
        }
    }
}