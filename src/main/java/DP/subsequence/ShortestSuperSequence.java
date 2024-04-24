package DP.subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestSuperSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1]; // Increase the size of dp array by 1 in both dimensions
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int shortestSuperSequenceLength = shortestSuperSequence(s, t, n, m, dp);
        System.out.println(shortestSuperSequenceLength);
    }

    private static int shortestSuperSequence(String s, String t, int i, int j, int[][] dp) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            return dp[i][j] = 1 + shortestSuperSequence(s, t, i - 1, j - 1, dp);
        }
        int takeS = 1 + shortestSuperSequence(s, t, i - 1, j, dp); // Include character from s
        int takeT = 1 + shortestSuperSequence(s, t, i, j - 1, dp); // Include character from t
        return dp[i][j] = Math.min(takeS, takeT);
    }
}
