package Hw4.ex4;

import java.util.*;

public class ClosestPair {
    private static class Point {
        double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static double bruteForce(Point[] points, int start, int end) {
        double minDist = Double.POSITIVE_INFINITY;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                double dist = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) +
                        Math.pow(points[i].y - points[j].y, 2));
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }
        return minDist;
    }

    private static double stripClosest(Point[] strip, double minDist) {
        double closest = minDist;
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < closest; j++) {
                double dist = Math.sqrt(Math.pow(strip[i].x - strip[j].x, 2) +
                        Math.pow(strip[i].y - strip[j].y, 2));
                if (dist < closest) {
                    closest = dist;
                }
            }
        }
        return closest;
    }

    private static double closestUtil(Point[] points, int start, int end) {
        if (end - start <= 2) {
            return bruteForce(points, start, end);
        }

        int mid = (start + end) / 2;
        double distLeft = closestUtil(points, start, mid);
        double distRight = closestUtil(points, mid + 1, end);
        double minDist = Math.min(distLeft, distRight);

        List<Point> strip = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (Math.abs(points[i].x - points[mid].x) < minDist) {
                strip.add(points[i]);
            }
        }

        Point[] stripArray = strip.toArray(new Point[0]);
        Arrays.sort(stripArray, (p1, p2) -> Double.compare(p1.y, p2.y));
        double stripDist = stripClosest(stripArray, minDist);

        return Math.min(minDist, stripDist);
    }

    public static double closestPair(Point[] points) {
        Arrays.sort(points, (p1, p2) -> Double.compare(p1.x, p2.x));
        return closestUtil(points, 0, points.length - 1);
    }

    public static void main(String[] args) {
        Point[] points = {new Point(2, 3), new Point(12, 30), new Point(40, 50),
                new Point(5, 1), new Point(12, 10), new Point(3, 4)};
        double closest = closestPair(points);
        System.out.println("The closest pair of points has distance " + closest);
    }
}
