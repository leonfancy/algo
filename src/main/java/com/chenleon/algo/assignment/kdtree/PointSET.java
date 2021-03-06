package com.chenleon.algo.assignment.kdtree;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.TreeSet;

public class PointSET {
    private TreeSet<Point2D> points;

    public PointSET() {
        points = new TreeSet<>();
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public int size() {
        return points.size();
    }

    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        points.add(p);
    }

    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        return points.contains(p);
    }

    public void draw() {
        for (Point2D point : points) {
            point.draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException();
        TreeSet<Point2D> containedPoints = new TreeSet<>();
        for (Point2D point : points) {
            if (rect.contains(point)) {
                containedPoints.add(point);
            }
        }

        return containedPoints;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        Point2D nearestP = null;
        double minDistance = Double.POSITIVE_INFINITY;
        for (Point2D point : points) {
            double distance = p.distanceSquaredTo(point);
            if (distance < minDistance) {
                nearestP = point;
                minDistance = distance;
            }
        }

        return nearestP;
    }
}
