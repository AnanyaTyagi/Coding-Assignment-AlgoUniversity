package DP.subsequence;

import java.util.Scanner;

public class AltSequenceLadiesGentlemen {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int mod = 1000000007;

            if (n == 1) {
                System.out.println(n);
                return;
            }

            int boys = 0, girls = 0, sum = 0;
            for (int i = 1; i <= n; i++) {
                //if i is even
                if (i % 2 == 0) {
                    boys = (boys + girls + 1) % mod;
                } else {
                    girls = (boys + girls + 1) % mod;
                }
            }

            sum = (girls + boys) % mod;
            System.out.println(sum);

            scanner.close();
        }
    }
