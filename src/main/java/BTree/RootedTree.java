package BTree;

import java.util.*;

public class RootedTree {

    public static void main(String[] args) {
        // Test case
        int[][] pairs = {{1,2}, {2,3}};
        int result = checkWays(pairs);
        System.out.println("Result: " + result);
    }
    public static int checkWays(int[][] pairs) {
        int result = 1; // Initialize result to 1
        // Create adjacency list
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        // Populate the adjacency list with pairs
        for (int[] pair : pairs) {
            edges.computeIfAbsent(pair[0], x -> new HashSet<>()).add(pair[0]); // Add pair[0] as its own ancestor
            edges.computeIfAbsent(pair[1], x -> new HashSet<>()).add(pair[1]); // Add pair[1] as its own ancestor
            edges.get(pair[0]).add(pair[1]); // Add pair[1] as an ancestor of pair[0]
            edges.get(pair[1]).add(pair[0]); // Add pair[0] as an ancestor of pair[1]
        }
        // Sort the edge lists based on their size
        List<Map.Entry<Integer, Set<Integer>>> edgesList = new ArrayList<>(edges.entrySet());
        Collections.sort(edgesList, (a, b) -> b.getValue().size() - a.getValue().size()); // Sort in descending order of size
   //node with highest children might actually be the root
        List<Map.Entry<Integer, Set<Integer>>> previous = new ArrayList<>(); // List to keep track of previously computed edges

        // Iterate through each edge in sorted order
        for (Map.Entry<Integer, Set<Integer>> cur : edgesList) {
            Set<Integer> currentSet = cur.getValue();
            // Get the current edge set
            // Find the parent for the current set from the previously computed edge
            Map.Entry<Integer, Set<Integer>> parent = find(previous, currentSet);
            // If parent is null
            if (parent == null) {
                // If the current set size is not equal to the edges size, then there is no way, return 0
                if (currentSet.size() != edges.size())
                    return 0;
            } else {
                Set<Integer> parentSet = parent.getValue(); // Get the parent set
                // If the current set does not contain everything from the parent, return 0
                if (!parentSet.containsAll(currentSet))
                    return 0;
                // If the parent contains everything from the current set, then there are more than one ways
                if (parentSet.equals(currentSet))
                    result = 2;
            }
            // Add the computed edge to the previous list
            previous.add(cur);
        }
        // Return the result
        return result;
    }

    // Find the parent for the current set from the previously computed edge
    public static Map.Entry<Integer, Set<Integer>> find(List<Map.Entry<Integer, Set<Integer>>> previous, Set<Integer> currentSet) {
        int i = previous.size() - 1;
        while (i >= 0) {
            Map.Entry<Integer, Set<Integer>> entry = previous.get(i--);
            if (currentSet.contains(entry.getKey()))
                return entry;
        }
        return null;
    }
}
