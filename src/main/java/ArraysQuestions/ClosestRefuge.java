package ArraysQuestions;

import java.util.HashMap;
import java.util.Scanner;

public class ClosestRefuge {

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            String n = s.nextLine();
            String stringOfNumbers = s.nextLine();
            s.close();
            String[] arrayOfNumbersString = stringOfNumbers.split(" ");
            HashMap<Integer, Integer> mapOfNumbers = new HashMap<>();

            for (int i = 0; i < Integer.valueOf(n); i++ ) {
                mapOfNumbers.put(Integer.valueOf(arrayOfNumbersString[i]), 1);
            }

            boolean flag = false;
            for (int i = 1; i <= Integer.valueOf(n); i++ ) {
                if(mapOfNumbers.get(i) == null){
                    flag = true;
                    System.out.print(i);
                    break;
                }
            }

            if(flag == false) {
                System.out.print(Integer.valueOf(n) + 1);
            }
        }
}
