package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CowArrival{

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        int[][] array = new int[N][2];

        for (int i = 0; i < N; i++) {
            array[i][0] = s.nextInt();
            array[i][1] = s.nextInt();
        }

        sortbyColumn(array, 0);

        long result = array[0][0]+ array[0][1];

        for (int i = 1; i < N; i++) {

            if(result==array[i][0]){
                result+=array[i][1];
            } else if (result>array[i][0]) {
                result+=array[i][1];
            } else {
                result+=array[i][1] + (array[i][0]-result);
            }
        }
        System.out.println(result);
    }

    public static void sortbyColumn(int arr[][], int col)
    {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare( int[] entry1,
                                int[] entry2) {
                int p = entry1[col] - entry2[col];
                if (p==0)
                    return entry1[col+1] - entry2[col+1];
                else
                    return p;
            }
        });
    }
}