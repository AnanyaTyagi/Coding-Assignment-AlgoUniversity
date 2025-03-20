package ArraysQuestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/max-points-on-a-line/description/
//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.



public class LineThroughPoints {

    public int lineThroughPoints(int[][] points) {
        if (points.length < 2) return points.length; // Less than 2 points

        int maxLength = 1;

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> slopeLengths = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                // Handle vertical line case
                if (points[j][0] == points[i][0]) {
                    slopeLengths.compute(Double.POSITIVE_INFINITY, (k, v) -> v == null ? 2 : v + 1); // Vertical line
                } else {
                    double slope = (double) (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                    slopeLengths.compute(slope, (k, v) -> v == null ? 2 : v + 1);
                }
            }
            maxLength = Math.max(maxLength, slopeLengths.values().stream().max(Comparator.naturalOrder()).orElse(0));
        }
        return maxLength;
    }
}
