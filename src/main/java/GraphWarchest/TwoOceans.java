package GraphWarchest;

import java.util.*;

public class TwoOceans {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        int[][] matrix = new int[n][m];
        int[][] solution = new int[n][m];

        // Read the input matrix values
        for (int i = 0; i < n; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        int[] distx = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] disty = {1, -1, 0, 1, -1, 0, 1, -1};


        // Creating adjacency map
        Map<Pair, List<Pair>> adjMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    int x = i + distx[k];
                    int y = j + disty[k];
                    if (x >= 0 && x < n && y >= 0 && y < m && matrix[i][j] >= matrix[x][y]) {
                        adjMap.putIfAbsent(new Pair(i, j), new ArrayList<>());

                        adjMap.get(new Pair(i, j)).add(new Pair(x, y));
                    }
                }
            }
        }

        // Perform BFS
        Queue<Pair> queue = new LinkedList<>();
        for (Pair pair : adjMap.keySet()) {
            if ((pair.x == 0 && pair.y == m - 1) ||( pair.x == n - 1 && pair.y == 0)) {
                queue.offer(pair);
                solution[pair.x][pair.y] = 1;
            }
        }

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if(!Objects.isNull(adjMap.get(current))) {
                for (Pair neighbor : adjMap.get(current)) {
                    if (solution[neighbor.x][neighbor.y] == 0) {
                        solution[neighbor.x][neighbor.y] = 1;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        solution[0][m-1]=1;
        solution[n-1][0]=1;
        // Print the solution
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static class Pair {

        private final int x;
        private final int y;

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            }

            final Pair pair = (Pair) o;

            if (x != pair.x) {
                return false;
            }
            if (y != pair.y) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
