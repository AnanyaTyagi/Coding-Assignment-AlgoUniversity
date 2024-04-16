package DP;

import java.util.Arrays;
import java.util.Scanner;

public class JumpingPossibiltities {

        static boolean helper(int[] arr, int target, int ind, int[][] dp) {
            if (target == 0) {
                return true;
            }
            if (ind >= arr.length) {
                return false;
            }
            if (dp[ind][target] != -1) {
                return dp[ind][target] == 0 ? false : true;
            }
            boolean nottake = helper(arr, target, ind + 1, dp);
            boolean take = false;
            //as negative target not allowed as dp array dimension, will throw error
            if (arr[ind] <= target) {
                take = helper(arr, target - arr[ind], ind + 1, dp);
            }
            dp[ind][target] = (nottake || take) ? 1 : 0;
            return nottake || take;
        }

        public static void main(String args[]) {
            Scanner s = new Scanner(System.in);
            int x = s.nextInt();
            while (x-- > 0) {
                int n = s.nextInt();
                int t = s.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = s.nextInt();
                }
                int[][] dp = new int[n + 1][t + 1];
                for (int[] a : dp) {
                    Arrays.fill(a, -1);
                }
                if (helper(arr, t, 0, dp))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int noOfTestCases = sc.nextInt();
//        for (int t = 0; t < noOfTestCases; t++) {
//            int N = sc.nextInt();
//            int S = sc.nextInt();
//            int[] jumpSize = new int[N + 1];
//            int[] dp = new int[N + 1];
//
//            for (int i = 1; i <= N; i++)
//                jumpSize[i] = sc.nextInt();
//
//            Arrays.fill(dp, -1);
//            int answer = recur(dp, S, N, 1, jumpSize);
//            System.out.println((answer == 1) ? "YES" : "NO");
//        }
//
//    }
//
//    private static int recur(int[] dp, int s, int n, int i, int[] jump) {
//        System.out.println("For index " + i + " and s " + s + " for n " + n);
//
//        if (s == 0)
//            return 1;
//        if (i == n+1)
//            return 0;
//        if (s < 0)
//            return 0;
//        if (dp[i] != -1)
//            return dp[i];
//        //the problem her is that ..if sum changes while addition and deletion and in dp no dimension of sum is there,
//        // swhat ends up happening is dp[i] gets set for wrong solution
//
//        int solution1 = recur(dp, s - jump[i], n, i + 1, jump);
//        int solution2 = recur(dp, s, n, i + 1, jump);
//
//
//        if (solution1 == 1 || solution2 == 1)
//            dp[i] = 1;
//        else
//            dp[i] = 0;
//     //   System.out.println("Solution1: "+solution1 + " ,Solution2: "+solution2 +" for index "+ i+"and s "+s);
//        return dp[i];
//    }

//Correct solution 2
//import java.util.Scanner;
//
//public class JumpDestination {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt(); // Number of test cases
//        for (int testCase = 0; testCase < t; testCase++) {
//            int n = scanner.nextInt(); // Number of jump lengths
//            int s = scanner.nextInt(); // Destination coordinate
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) {
//                a[i] = scanner.nextInt();
//            }
//            if (canReachDestination(n, s, a)) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//        }
//    }
//
//    private static boolean canReachDestination(int n, int s, int[] a) {
//        boolean[][] dp = new boolean[n + 1][s + 1];
//        dp[0][0] = true;
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= s; j++) {
//                if (j - a[i - 1] >= 0 && dp[i - 1][j - a[i - 1]]) {
//                    dp[i][j] = true;
//                }
//                if (dp[i - 1][j]) {
//                    dp[i][j] = true;
//                }
//            }
//        }
//
//        return dp[n][s];
//    }
//}
