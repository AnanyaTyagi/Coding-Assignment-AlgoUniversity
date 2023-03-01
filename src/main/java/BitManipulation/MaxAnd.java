package BitManipulation;

import java.util.Scanner;

public class MaxAnd {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]= new int[n];

        for(int i = 0; i< n ; i++) {
            arr[i] = scanner.nextInt();

        }
        int res = 0, count;

        // iterate over total of 32bits
        // from msb to lsb
        for (int bit = 31; bit >= 0; bit--) {
            // find the count of element
            // having set msb
            count = checkBit(res | (1 << bit), arr, n);

            // if count >= 2 set particular
            // bit in result
            if (count >= 2)
                res |= (1 << bit);
        }

        System.out.println(res);

    }

    static int checkBit(int pattern, int arr[], int n)
    {
        int count = 0;
        for (int i = 0; i < n; i++)
            if ((pattern & arr[i]) == pattern)
                count++;
        return count;
    }

}
