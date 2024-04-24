package DP.OtherVariants;


import java.util.Arrays;
import java.util.Scanner;

public class RemoveElements {
//todo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(maxScoreRecursive(A, 0, n - 1, dp));
    }

    // Function to find the maximum score recursively
    private static int maxScoreRecursive(int[] A, int start, int end, int[][] dp) {
        // Base case: If the range contains only one element, return its value
        if (start == end) {
            return (start > 0 ? A[start - 1] : 1) * A[start] * (end < A.length - 1 ? A[end + 1] : 1);
        }

        if(dp[start][end]!=-1)
            return dp[start][end];
        int maxScore = Integer.MIN_VALUE;
        // Try removing each element in the range and recursively calculate the score
        for (int i = start; i <= end; i++) {
            int left = (start == 0) ? 1 : A[start - 1];
            int right = (end == A.length - 1) ? 1 : A[end + 1];
            int currentScore = left * A[i] * right;
            int leftScore = (i > start) ? maxScoreRecursive(A, start, i - 1, dp) : 0;
            int rightScore = (i < end) ? maxScoreRecursive(A, i + 1, end, dp) : 0;
            maxScore = Math.max(maxScore, currentScore + leftScore + rightScore);

        }
        return dp[start][end]= maxScore;
    }
}
