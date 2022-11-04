package RangeQueriesPrefixSum;

import java.util.Scanner;

public class Sphinx {

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            String N = s.nextLine();
            int[] array = new int[Integer.valueOf(N)+1];
            String stringOfNumbers = s.nextLine();
            String[] arrayOfNumbers = stringOfNumbers.split(" ");
            String Q = s.nextLine();

            int sum = 0;
            for (int i = 1; i <= Integer.valueOf(N); i++) {
                sum +=Integer.valueOf(arrayOfNumbers[i-1]);
                array[i]= sum;
            }
           // int[] results = new int[Integer.valueOf(N)];
            for(int i = 0; i<Integer.valueOf(Q) ; i++) {
                String stringOfQuery = s.nextLine();
                String[] arrayOfQuery = stringOfQuery.split(" ");
                if(Integer.valueOf(arrayOfQuery[0]) == 1){
                   System.out.println(array[Integer.valueOf(arrayOfQuery[1])]);
                    continue;
                }
                System.out.println(array[Integer.valueOf(arrayOfQuery[1])]-array[Integer.valueOf(arrayOfQuery[0])-1]);
            }

//            for(int i = 0; i<Integer.valueOf(Q) ; i++) {
//                  System.out.println(results[i]);
//              }
            }
}
