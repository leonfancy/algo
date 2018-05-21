package com.chenleon.pattern;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> segments;

    public BruteCollinearPoints(Point[] points) {
        segments = new ArrayList<>();

        Arrays.sort(points);

        for(int i = 0; i < points.length - 1; i++) {
            if(points[i] == null || points[i+1] == null)
                throw new IllegalArgumentException("Null point");
            if(points[i].compareTo(points[i+1]) == 0)
                throw new IllegalArgumentException("Duplicate points");
        }

        for (int p = 0; p < points.length; p++)
            for (int q = p + 1; q < points.length; q++)
                for (int r = q + 1; r < points.length; r++)
                    for (int s = r + 1; s < points.length; s++) {
                        double pqSlope = points[p].slopeTo(points[q]);
                        double prSlope = points[p].slopeTo(points[r]);
                        double psSlope = points[p].slopeTo(points[s]);
                        if ((pqSlope == prSlope) && (prSlope == psSlope)) {
                            segments.add(new LineSegment(points[p], points[s]));
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
