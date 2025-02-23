package ArraysQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquaresGoogle {

//    Save all coordinates to a list, in the meanwhile count the frequencies of each coordinate in a hashmap
//    During count method, check if each coordinate form a square diagnol with the query point, if so, use the counts of the other two coordinates of the square to calculate the total
//    e.g.
//            x, y and px, py formed a diagnol for a square size of |px -x|, now we just need to see the counts of (x, py) and (px, y).
//    using @ for map coordinate keys

    public class DetectSquares {
        // List to store coordinates of points
        List<int[]> coordinates;
        // Map to store counts of each unique point
        Map<String, Integer> counts;

        // Constructor to initialize lists and maps
        public DetectSquares() {
            coordinates = new ArrayList<>();
            counts = new HashMap<>();
        }

        // Method to add a new point to the lists and maps
        public void add(int[] point) {
            // Add the point to the coordinates list
            coordinates.add(point);
            // Generate a key for the point in the counts map
            String key = point[0] + "@" + point[1];
            // Increment the count for the point in the counts map
            counts.put(key, counts.getOrDefault(key, 0) + 1);
        }

        // Method to count squares with the given point as one of the vertices
        public int count(int[] point) {
            // Initialize a variable to store the count of squares
            int sum = 0;
            // Extract the x and y coordinates of the given point
            int px = point[0], py = point[1];
            // Iterate over each point in the coordinates list
            for (int[] coordinate : coordinates) {
                // Extract the x and y coordinates of the current point
                int x = coordinate[0], y = coordinate[1];
                // Check if the current point can form a square with the given point
                if (px == x || py == y || (Math.abs(px - x) != Math.abs(py - y)))
                    continue; // If not, skip to the next point
                // Calculate the count of squares using counts of other two vertices
                sum += counts.getOrDefault(x + "@" + py, 0) * counts.getOrDefault(px + "@" + y, 0);
            }
            // Return the count of squares formed with the given point as one of the vertices
            return sum;
        }
    }

}
