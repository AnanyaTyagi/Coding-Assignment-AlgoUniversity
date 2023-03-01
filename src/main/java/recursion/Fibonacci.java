package recursion;

import java.util.Scanner;
public class Fibonacci {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(fibo(N));
    }

    private static int fibo(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        return fibo(n-1) + fibo(n-2);
    }
}
