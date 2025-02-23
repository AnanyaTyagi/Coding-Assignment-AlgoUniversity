package ArraysQuestions;

import java.util.Arrays;

public class MergeOveralppingIntervals {

        public int[][] mergeOverlappingIntervals(int[][] intervals) {
            // Write your code here.
            if (intervals.length == 0) {
                return new int[0][0];
            }


            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            int[][] results = new int[intervals.length][2];
            int index = 0;
            results[index] = intervals[0];

            for (int i = 1; i < intervals.length; i++) {
                // If the current interval overlaps with the last added interval, merge them
                if (results[index][1] >= intervals[i][0]) { // Overlapping condition
                    results[index][1] = Math.max(results[index][1], intervals[i][1]); // Merge
                } else { // If not overlapping, just add it to results
                    index++;
                    results[index] = intervals[i];
                }
            }

            return Arrays.copyOf(results, index + 1);
        }


}
