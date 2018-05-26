package com.chenleon.algo.assignment.collinear;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> segments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("Null arguments");

        segments = new ArrayList<>();

        int N = points.length;
        Point[] auxps = new Point[N];

        for (int i = 0; i < N; i++) {
            if (points[i] == null)
                throw new IllegalArgumentException("Null point");
            auxps[i] = points[i];
        }

        Arrays.sort(auxps);

        for (int i = 0; i < N - 1; i++) {
            if (auxps[i].compareTo(auxps[i + 1]) == 0)
                throw new IllegalArgumentException("Duplicate points");
        }

        for (int p = 0; p < N; p++)
            for (int q = p + 1; q < N; q++)
                for (int r = q + 1; r < N; r++)
                    for (int s = r + 1; s < N; s++) {
                        double pqSlope = auxps[p].slopeTo(auxps[q]);
                        double prSlope = auxps[p].slopeTo(auxps[r]);
                        double psSlope = auxps[p].slopeTo(auxps[s]);
                        if ((pqSlope == prSlope) && (prSlope == psSlope)) {
                            segments.add(new LineSegment(auxps[p], auxps[s]));
                        }
                    }
    }

    public int numberOfSegments() {
        return segments.size();
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
