package ArraysQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreasureRoomEasyV2 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String numbers = s.nextLine();
        String stringOfNumbers = s.nextLine();
        s.close();
        String[] nAndW = numbers.split(" ");
        Integer n = Integer.valueOf(nAndW[0]);
        Integer w = Integer.valueOf(nAndW[1]);
        String[] arrayOfNumbersString = stringOfNumbers.split(" ");
        List<Integer> arrayOfNumbers = new ArrayList<>();
        Map<Integer, Integer> mapOfSubtraction = new HashMap<>();
        Map<Integer, Integer> mapOfCount = new HashMap<>();

            for (int i = 0; i < n; i++) {

                 arrayOfNumbers.add(Integer.valueOf(arrayOfNumbersString[i]));
                if(!mapOfSubtraction.containsKey(w-arrayOfNumbers.get(i))) {
                    mapOfCount.put(arrayOfNumbers.get(i), 1);
                    mapOfSubtraction.put(w - arrayOfNumbers.get(i), i);
                    continue;
                }
                int count = mapOfCount.get(arrayOfNumbers.get(i));
                  System.out.println(count);
                if(mapOfSubtraction.containsKey(w-arrayOfNumbers.get(i)) && count <3) {
                    count ++;
                mapOfCount.put(arrayOfNumbers.get(i),count);
                mapOfSubtraction.put(w - arrayOfNumbers.get(i), i);
                continue;
                }

        }

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; i < n; j++) {
                int sum = arrayOfNumbers.get(i) + arrayOfNumbers.get(j);
                if((mapOfSubtraction.containsKey(sum)) && !(mapOfSubtraction.get(sum)== i) && !(mapOfSubtraction.get(sum) == j)) {
                   flag = true;

                    System.out.print((i+1) + " " + (j+1) + " " + (mapOfSubtraction.get(sum)+1));
                   break;
               }
            }
            if(flag == true)
                break;
        }

        if(flag == false)
        System.out.println(-1);
    }
}