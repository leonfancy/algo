package com.chenleon.algo.assignment.collinear;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private ArrayList<LineSegment> segments;

    public FastCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("Null arguments");

        segments = new ArrayList<>();
        int N = points.length;
        Point[] auxps = new Point[N];

        for (int i = 0; i < N; i++) {
            if (points[i] == null)
                throw new IllegalArgumentException("Null Point");
            auxps[i] = points[i];
        }

        if (N < 2) return;

        for (Point point : points) {
            Arrays.sort(auxps, point.slopeOrder());

            // duplicate points will be in the first positions
            if (auxps[0].compareTo(auxps[1]) == 0)
                throw new IllegalArgumentException("Duplicate Point");

            // First element is the point itself, so ignore it.
            int min = 1, max = 1;
            int count = 1;
            for (int i = 2; i < N; i++) {
                if (point.slopeTo(auxps[i]) == point.slopeTo(auxps[i - 1])) {
                    if (auxps[i].compareTo(auxps[min]) < 0) min = i;
                    else if (auxps[i].compareTo(auxps[max]) > 0) max = i;
                    count++;
                    if (i == N - 1 && count >= 3 && point.compareTo(auxps[min]) < 0)
                        segments.add(new LineSegment(point, auxps[max]));
                } else {
                    // Only add line segment with source point as the origin
                    if (count >= 3 && point.compareTo(auxps[min]) < 0)
                        segments.add(new LineSegment(point, auxps[max]));
                    min = i;
                    max = i;
                    count = 1;
                }
            }
        }
    }

    public int numberOfSegments() {
        return segments.size();
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[0]);
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
