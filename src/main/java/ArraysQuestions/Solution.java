package ArraysQuestions;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] A) {
        int n = A.length;

        // dp[i] represents the minimum number of moves required to achieve the desired
        // frequency for all elements up to index i (inclusive)
        int[] dp = new int[n];

        // Base case: if the first element appears only once, no moves required
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            // Inherit the minimum moves from the previous element (assuming same frequency)
            dp[i] = dp[i - 1];

            // Calculate the cost of removing elements if current count exceeds previous count
            if (A[i] == A[i - 1]) {
                int prevCount = (i - 1 >= 0 && A[i - 1] == A[i - 2]) ? A[i - 1] : 1; // Consider previous element's frequency
                dp[i] = Math.min(dp[i], dp[i - 1] + (i - prevCount));
            } else {
                // Calculate the cost of inserting elements if current count is less than previous count (or 1)
                dp[i] = Math.min(dp[i], dp[i - 1] + (i - A[i - 1]));
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 1, 3, 4, 4, 4})); // Expected Output: 3
        System.out.println(s.solution(new int[]{1, 2, 2, 2, 5, 5, 5, 8})); // Expected Output: 4
        System.out.println(s.solution(new int[]{1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4})); // Expected Output: 5
        System.out.println(s.solution(new int[]{10, 10, 10})); // Expected Output: 3
        System.out.println(s.solution(new int[]{1, 6, 6, 6, 6, 6, 6})); // Expected Output: 1
    }
}
