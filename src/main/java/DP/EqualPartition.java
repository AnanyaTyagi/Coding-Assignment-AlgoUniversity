package DP;

import java.util.Scanner;

public class EqualPartition {

    static int H, N, totalSum;
    static int[] chocaltes;
    static boolean[][] dp ;


    public static boolean solver(int index, int sum) {
        if(sum == 0)
            return true;
        if(index == N)
            return false;
        if (dp[index][sum])
            return false;


        dp[index][sum] = true;


        if (chocaltes[index] <= sum && solver(index + 1, sum - chocaltes[index]))
            return true;


        return solver(index + 1, sum);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int k = 0 ; k < tc ; k++){
            N = sc.nextInt();
            chocaltes = new int[N];
            totalSum = 0;
            for (int i = 0; i < N; i++) {
                chocaltes[i] = sc.nextInt();
                totalSum+= chocaltes[i];
            }
            if(totalSum%2 == 1){
                System.out.println("NO");
                continue;
            }
            dp = new boolean[N][totalSum/2 +1];
            if(solver(0 , totalSum/2))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}

