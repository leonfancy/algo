package com.chenleon.algo.assignment.kdtree;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Set;
import java.util.TreeSet;

public class KdTree {
    private Node root;
    private int size = 0;

    public KdTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        if (!contains(p)) {
            root = insert(root, p, true);
            size++;
        }
    }

    private Node insert(Node x, Point2D p, boolean isX) {
        if (x == null) return new Node(null, p, null);

        double pKey = isX ? p.x() : p.y();
        double xKey = isX ? x.p.x() : x.p.y();

        if (pKey < xKey) x.lb = insert(x.lb, p, !isX);
        else x.rt = insert(x.rt, p, !isX);

        return x;
    }

    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        return contains(root, p, true);
    }

    private boolean contains(Node x, Point2D p, boolean isX) {
        if (x == null) return false;
        if (x.p.equals(p)) return true;

        double pKey = isX ? p.x() : p.y();
        double xKey = isX ? x.p.x() : x.p.y();

        if (pKey < xKey) return contains(x.lb, p, !isX);
        else return contains(x.rt, p, !isX);
    }


    public void draw() {
        draw(root, true, 0, 0, 1, 1);
    }

    private void draw(Node x, boolean isX, double xmin, double ymin, double xmax, double ymax) {
        if (x == null) return;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        x.p.draw();

        StdDraw.setPenRadius();
        if (isX) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(x.p.x(), ymin, x.p.x(), ymax);
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(xmin, x.p.y(), xmax, x.p.y());
        }

        if (isX) {
            draw(x.lb, !isX, xmin, ymin, x.p.x(), ymax);
            draw(x.rt, !isX, x.p.x(), ymin, xmax, ymax);
        } else {
            draw(x.lb, !isX, xmin, ymin, xmax, x.p.y());
            draw(x.rt, !isX, xmin, x.p.y(), xmax, ymax);
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException();
        Set<Point2D> points = new TreeSet<>();
        range(points, root, rect, true);
        return points;
    }

    private void range(Set<Point2D> points, Node x, RectHV rect, boolean isX) {
        if (x == null) return;
        if (rect.contains(x.p)) points.add(x.p);

        double xKey = isX ? x.p.x() : x.p.y();
        double rMin = isX ? rect.xmin() : rect.ymin();
        double rMax = isX ? rect.xmax() : rect.ymax();

        if (rMax > xKey) range(points, x.rt, rect, !isX);
        if (rMin < xKey) range(points, x.lb, rect, !isX);
    }

    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        return nearest(root, p, null, new RectHV(0, 0, 1, 1), true);
    }

    private Point2D nearest(Node x, Point2D p, Point2D minP, RectHV rect, boolean isX) {
        if (x == null) return minP;
        if (minP == null || p.distanceSquaredTo(x.p) < p.distanceSquaredTo(minP)) minP = x.p;

        RectHV lRect = isX ? new RectHV(rect.xmin(), rect.ymin(), x.p.x(), rect.ymax())
                : new RectHV(rect.xmin(), rect.ymin(), rect.xmax(), x.p.y());
        RectHV rRect = isX ? new RectHV(x.p.x(), rect.ymin(), rect.xmax(), rect.ymax())
                : new RectHV(rect.xmin(), x.p.y(), rect.xmax(), rect.ymax());

        double xKey = isX ? x.p.x() : x.p.y();
        double pKey = isX ? p.x() : p.y();

        if (pKey < xKey) {
            minP = nearest(x.lb, p, minP, lRect, !isX);
            if (p.distanceSquaredTo(minP) > rRect.distanceSquaredTo(p))
                minP = nearest(x.rt, p, minP, rRect, !isX);
        } else {
            minP = nearest(x.rt, p, minP, rRect, !isX);
            if (p.distanceSquaredTo(minP) > rRect.distanceSquaredTo(p))
                minP = nearest(x.lb, p, minP, lRect, !isX);
        }

        return minP;
    }

    private class Node {
        private Point2D p;
        private Node lb;
        private Node rt;

        Node(Node lb, Point2D p, Node rt) {
            this.p = p;
            this.lb = lb;
            this.rt = rt;
        }
    }
}
