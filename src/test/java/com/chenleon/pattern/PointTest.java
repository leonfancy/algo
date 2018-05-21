package com.chenleon.pattern;

import org.junit.Test;

import java.util.Comparator;

import static junit.framework.TestCase.assertEquals;


public class PointTest {
    @Test
    public void testVerticalSlope() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        assertEquals(Double.POSITIVE_INFINITY, p1.slopeTo(p2));
    }

    @Test
    public void testHorizontalSlope() {
        Point p1 = new Point(2, 1);
        Point p2 = new Point(1, 1);
        assertEquals(+0.0, p1.slopeTo(p2));
    }

    @Test
    public void testEqualSlope() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        assertEquals(Double.NEGATIVE_INFINITY, p1.slopeTo(p2));
    }

    @Test
    public void testNormalSlope() {
        Point p1 = new Point(2, 1);
        Point p2 = new Point(4, 2);
        assertEquals(0.5, p1.slopeTo(p2));
    }

    @Test
    public void testShouldCompareByY() {
        Point p1 = new Point(2, 1);
        Point p2 = new Point(1, 2);
        assertEquals(true, p1.compareTo(p2) < 0);
    }

    @Test
    public void testShouldCompareByXWhenYEquals() {
        Point p1 = new Point(2, 1);
        Point p2 = new Point(1, 1);
        assertEquals(true, p1.compareTo(p2) > 0);
    }

    @Test
    public void testReturnEqualGivenSamePoint() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        assertEquals(true, p1.compareTo(p2) == 0);
    }

    @Test
    public void testLowSlopePointShouldBeLessThanHighSlopePoint() {
        Point p0 = new Point(1, 1);
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 3);
        Comparator<Point> comparator = p0.slopeOrder();
        assertEquals(true, comparator.compare(p1, p2) < 0);
    }

    @Test
    public void testSlopeOrderShouldRightGivenVerticalPoints() {
        Point p0 = new Point(1, 1);
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 3);
        Comparator<Point> comparator = p0.slopeOrder();
        assertEquals(true, comparator.compare(p1, p2) == 0);
    }

    @Test
    public void testSlopeOrderShouldRightGivenHorizontalPoints() {
        Point p0 = new Point(1, 2);
        Point p1 = new Point(2, 2);
        Point p2 = new Point(3, 2);
        Comparator<Point> comparator = p0.slopeOrder();
        assertEquals(true, comparator.compare(p1, p2) == 0);
    }

    @Test
    public void testSlopeOrderShouldRightGivenSamePoints() {
        Point p0 = new Point(1, 2);
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Comparator<Point> comparator = p0.slopeOrder();
        assertEquals(true, comparator.compare(p1, p2) == 0);
    }
}