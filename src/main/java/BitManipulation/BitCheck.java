package BitManipulation;

import java.util.Scanner;

public class BitCheck {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextInt();

        long i = n &(1<<k);

        System.out.println(i>0? 1:0);
    }
}
