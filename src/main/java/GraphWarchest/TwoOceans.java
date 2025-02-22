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
 //C++ recursive solution
//
//#include <bits/stdc++.h>
//        using namespace std;
//
//        #define int long long
//        #define inf LONG_LONG_MAX
//        #define double long double
//        #define all(x) x.begin(), x.end()
//        #define rev(x) x.rbegin(), x.rend()
//        #define el cout << "\n";
//        #define YES cout << "YES" << endl;
//        #define Yes cout << "Yes" << endl;
//        #define NO cout << "NO" << endl;
//        #define No cout << "No" << endl;
//        #define vi vector<int>
//        #define vv vector<vector<int>>
//        #define pii pair<int, int>
//        #define vii vector<pair<int, int>>
//
//        const int M = 1e9 + 7;
//        int mod_add(int a, int b)
//        {
//        a = a % M;
//        b = b % M;
//        return (((a + b) % M) + M) % M;
//        }
//
//        vector<vv> dp(1e6 + 2, vv(2, vi(2, -1)));
//        int fun(const int n, int i, int id, int prev)
//        {
//        if (i >= n)
//        {
//        return 0;
//        }
//
//        if (dp[i][id][prev] != -1)
//        {
//        return dp[i][id][prev];
//        }
//
//        dp[i][id][prev] = 0;
//        if (id == (i % 2) && (id != prev))
//        {
//        dp[i][id][prev] = mod_add(1, fun(n, i + 1, id ^ 1, prev ^ 1));
//        }
//
//        dp[i][id][prev] = mod_add(dp[i][id][prev], fun(n, i + 1, id ^ 1, prev));
//        return dp[i][id][prev];
//        }
//
//        signed main()
//        {
//        ios_base::sync_with_stdio(false);
//        cin.tie(NULL);
//
//        int n;
//        cin >> n;
//
//        for (int i = 0; i < n + 1; i++)
//        {
//        for (int j = 0; j < 2; j++)
//        {
//        for (int k = 0; k < 2; k++)
//        {
//        dp[i][j][k] = -1;
//        }
//        }
//        }
//
//        int a = fun(n, 0, 0, 1);
//        int b = fun(n, 0, 0, 0);
//
//        cout << mod_add(a, b);