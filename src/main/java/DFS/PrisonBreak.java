package DFS;

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class PrisonBreak {
    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        char[][] map = new char[n][m];
        char[][] vis = new char[n][m];
        Deque<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'A') {
                    q.add(new Pair(i, j));
                    if ((i == 0 || i == n - 1 || j == 0 || j == m - 1)) {
                        System.out.println("YES");
                        return;
                    }
                } else if (map[i][j] == 'M') {
                    q.addFirst(new Pair(i, j));
                }
                vis[i][j] = map[i][j];
            }
        }

        int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } }; // {L, T, R, D} -> all 4 directions

        while (!q.isEmpty()) {
            Pair p = q.removeFirst();
            for (int[] next : dir) {
                int x = p.x + next[0];
                int y = p.y + next[1];
                if (isValid(x, y, n, m, vis)) {
                    vis[x][y] = vis[p.x][p.y];
                    if ((x == 0 || x == n - 1 || y == 0 || y == m - 1) && vis[x][y] == 'A') {
                        System.out.println("YES");
                        return;
                    }
                    q.add(new Pair(x, y));
                }
            }
        }
        System.out.println("NO");
    }

    public static boolean isValid(int x, int y, int n, int m, char[][] vis) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        if (vis[x][y] != '.')
            return false;
        return true;
    }
}