package RangeQueriesPrefixSum;

import java.util.Scanner;

public class Sphinx {

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            Long N = s.nextLong();
            long[] array = new long[(int) (N+1)];

            long sum = 0;
            for (int i = 1; i <= N; i++) {
                array[i] = s.nextLong();
                sum +=array[i];
                array[i]= sum;
            }
            Long Q = s.nextLong();

            for(int i = 0; i<Q ; i++) {
                Long l = s.nextLong();
                Long r = s.nextLong();
                if(l == 1){
                   System.out.println(array[Math.toIntExact(r)]);
                    continue;
                }
                System.out.println(array[Math.toIntExact(r)]-array[(int) (l-1)]);
            }

            }
}
