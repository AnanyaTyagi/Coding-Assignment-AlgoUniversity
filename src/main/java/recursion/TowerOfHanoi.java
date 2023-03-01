package recursion;

import java.util.Scanner;

public class TowerOfHanoi {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((int)Math.pow(2, n) - 1);
        towerOfHanoi(n, 1, 2 , 3);
    }

    private static void towerOfHanoi(int n, int from, int to, int aux) {
        if (n == 0)
            return;
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println(n + " "+ from + " "+ to);
        towerOfHanoi(n - 1, aux, to, from);
    }
}
