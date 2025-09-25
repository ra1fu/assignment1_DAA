package org.example;

import java.util.*;

public class ClosestPair2D implements Algorithm<ClosestPair2D.Point[], Double> {

    public static class Point {
        double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public Double run(Point[] points) {
        return closestPair(points);
    }

    public static double closestPair(Point[] points) {
        Arrays.sort(points, Comparator.comparingDouble(p -> p.x));
        return closest(points, 0, points.length - 1);
    }

    private static double closest(Point[] pts, int l, int r) {
        if (r - l <= 3) return bruteForce(pts, l, r);

        int mid = (l + r) / 2;
        double d1 = closest(pts, l, mid);
        double d2 = closest(pts, mid + 1, r);
        double d = Math.min(d1, d2);

        List<Point> strip = new ArrayList<>();
        double midX = pts[mid].x;
        for (int i = l; i <= r; i++) {
            if (Math.abs(pts[i].x - midX) < d) strip.add(pts[i]);
        }
        strip.sort(Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < d; j++) {
                d = Math.min(d, dist(strip.get(i), strip.get(j)));
            }
        }
        return d;
    }

    private static double bruteForce(Point[] pts, int l, int r) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = l; i <= r; i++) {
            for (int j = i + 1; j <= r; j++) {
                min = Math.min(min, dist(pts[i], pts[j]));
            }
        }
        return min;
    }

    private static double dist(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}
