package SearchingSorting;

import java.util.Scanner;

public class DirectBinarySearch {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String size = s.nextLine();
        String[] sizeOfMatrix = size.split(" ");
        int N = Integer.valueOf(sizeOfMatrix[0]);
        int Q = Integer.valueOf(sizeOfMatrix[1]);
        int[] array = new int[N];
        String stringOfNumbers = s.nextLine();
        String[] arrayOfNumbers = stringOfNumbers.split(" ");

        String stringOfQueries = s.nextLine();
        String[] arrayOfQueries = stringOfQueries.split(" ");

        for (int i = 0; i < N; i++) {
            array[i] = Integer.valueOf(arrayOfNumbers[i]);
        }

        for (int i = 0; i < Q; i++) {
          binarySearch(Integer.valueOf(arrayOfQueries[i]), array);
        }
    }

    public static void binarySearch(int x, int[] array) {

        long l = 0;
        long r = array.length-1;
        while(l<=r) {
            long m = l + (r-l)/2;
            if(array[(int) m] == x) {
               System.out.println(m);
               break;
             }

            if(array[(int) m] < x){
                l = m + 1;
            } else {
                r = m-1;
            }
        }
    }
}
