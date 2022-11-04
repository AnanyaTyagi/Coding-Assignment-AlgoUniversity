package ArraysQuestions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreasureRoomEasy {

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

        for( int i = 0; i < arrayOfNumbersString.length; i++) {
            arrayOfNumbers.add(Integer.valueOf(arrayOfNumbersString[i]));
        }

        LinkedHashMap<Integer, Integer> mapOfNumbers = new LinkedHashMap<>();

        for (int i = 0; i < arrayOfNumbers.size(); i++ ) {
            if(!mapOfNumbers.containsKey(arrayOfNumbers.get(i))) {
                mapOfNumbers.put(arrayOfNumbers.get(i), 1);
            } else {
                Integer m= mapOfNumbers.get(arrayOfNumbers.get(i));
                mapOfNumbers.put(arrayOfNumbers.get(i), m+1);
            }
        }

        boolean flag = false;

        for(Map.Entry<Integer, Integer> entry: mapOfNumbers.entrySet()){
            if(mapOfNumbers.containsKey(w - entry.getKey()) && !(entry.getKey()==(w - entry.getKey()))) {
                flag = true;
                System.out.println((arrayOfNumbers.indexOf(entry.getKey()) + 1)+ " " + (arrayOfNumbers.indexOf(w - entry.getKey()) + 1));
                break;
            }
            if(entry.getKey() == (w - entry.getKey()) &&  entry.getValue() > 1){
                flag = true;
                int firstIndex = arrayOfNumbers.indexOf(entry.getKey()) + 1;
                arrayOfNumbers.add(arrayOfNumbers.indexOf(entry.getKey()), -1);
                int secondIndex = arrayOfNumbers.indexOf(entry.getKey()) + 1;
                System.out.println(firstIndex + " " + secondIndex );
            }
        }
        if(flag == false)
            System.out.println(-1);
    }
}
