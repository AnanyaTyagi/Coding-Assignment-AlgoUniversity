package misc;

import java.math.BigInteger;

public class Factorial {

    public static void main(String args[]){
        BigInteger number = 100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000;
        System.out.println(factorial(number));
    }

    public static long factorial(long n){
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
