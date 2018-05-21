package com.chenleon.pattern;

import org.junit.Test;

import static org.junit.Assert.*;

public class FastCollinearPointsTest {
    @Test
    public void testVerticalLine() {
        Point[] points = new Point[4];
        points[0] = new Point(1, 1);
        points[1] = new Point(1, 2);
        points[2] = new Point(1, 3);
        points[3] = new Point(1, 4);
        FastCollinearPoints fast = new FastCollinearPoints(points);
        assertEquals(1, fast.numberOfSegments());
        assertEquals("(1, 1) -> (1, 4)", fast.segments()[0].toString());
    }
}