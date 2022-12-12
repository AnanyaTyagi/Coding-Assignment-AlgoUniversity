package BinarySearchOverAnswer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Transport {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int C = scanner.nextInt();
        long array[] = new long[N];

        for(int i = 0; i<N; i++){
            array[i] = scanner.nextLong();
        }
        Arrays.sort(array);
        double l = 0;
        double r = 1e18;

        while(l+1<r){
            double mid = l + ((r-l)/2);
            if(predicate(array, N, M, C, mid)==0){
                l = mid;
            } else{

                r = mid;
            }
        }

        System.out.println((int) Math.floor(r));
    }

    private static int predicate(long[] array, int n, int m, int c, double mid) {
        long firstPerson = array[0];
        int buses = 1, current_capacity = 1, i = 0;


        while(i<array.length){

            if(array[i] - firstPerson > mid || current_capacity > c){
                buses++;
                current_capacity = 1;
                firstPerson = array[i];

            }
              i++;
            current_capacity++;

        }
       if(buses <= m)
           return 1;
       return 0;
    }
}
