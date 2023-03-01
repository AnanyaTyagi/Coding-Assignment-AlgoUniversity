package BitManipulation;

import java.util.Scanner;

public class LongestConsecutiveOne {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0; i< n ; i++) {
            long x = scanner.nextLong();

            int count = 0;

            // Count the number of iterations to
            // reach x = 0.
            while (x!=0)
            {
                // This operation reduces length
                // of every sequence of 1s by one.
                x = (x & (x << 1));

                count++;
            }

            System.out.println(count);

        }


    }
}
