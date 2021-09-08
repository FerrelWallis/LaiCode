package cross_training3;

import javafx.util.Pair;

import java.util.HashMap;

public class MostPointsOnALine_216 {
    //Given an array of 2D coordinates of points (all the coordinates are integers),
    //find the largest number of points that can be crossed by a single line in 2D space.
    //Assumptions: The given array is not null and it has at least 2 points

    //Examples
    //<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3
    //(<0, 0>, <1, 1>, <3, 3> are on the same line)

    //HashMap< key = <slope, intercept>, value = HashSet<Point>>
    //y = slope  x + intercept

    //用一个点和一个斜率确定一条线，寻找线上所有的点
    public int most2(Point[] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            int samep = 1;
            int samex = 0;
            int most = 0;
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                Point p2 = points[j];
                if (i == j) {
                    continue;
                }
                if (p1.x == p2.x && p1.y == p2.y) {
                    samep++;
                } else if (p1.x == p2.x) {
                    samex++;
                } else {
                    double slope = ((p1.y - p2.y) + 0.0) / (p1.x - p2.x);
                    int count = map.containsKey(slope) ? map.get(slope) + 1 : 1;
                    map.put(slope, count);
                    most = Math.max(most, map.get(slope));
                }
            }
            most = Math.max(max, samex) + samep;
            max = Math.max(max, most);
        }
        return max;
    }


    //上课方法
    public int most(Point[] p) {
        int result = 0;
        HashMap<Pair<Double, Double>, Integer> sloIntCount = new HashMap<>();
        HashMap<Integer, Integer> verticalCount = new HashMap<>();
        int max = 0;
        for (int i = 0; i < p.length; i++) {
            Point p1 = p[i];
            for (int j = i + 1; j < p.length; j++) {
                Point p2 = p[j];
                int count = 0;
                if (p1.x == p2.x) {
                    count = verticalCount.containsKey(p1.x) ? verticalCount.get(p1.x) + 1 : 1;
                    verticalCount.put(p1.x, count);
                } else {
                    double slope = (p1.y - p2.y) / (p1.x - p2.x);
                    double intercept = p1.y - slope * p1.x;
                    Pair<Double, Double> pair = new Pair<>(slope, intercept);
                    count = sloIntCount.containsKey(pair) ? sloIntCount.get(pair) + 1 : 1;
                    sloIntCount.put(pair, count);
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }


    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
