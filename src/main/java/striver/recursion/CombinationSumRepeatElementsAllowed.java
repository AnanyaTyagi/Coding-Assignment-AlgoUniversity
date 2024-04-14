package striver.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CombinationSumRepeatElementsAllowed {

    public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    String noOfElements = s.nextLine();
    String stringOfNumbers = s.nextLine();
    String targetString = s.nextLine();
    s.close();
    Integer n = Integer.valueOf(noOfElements);
    Integer target = Integer.valueOf(targetString);
    String[] arrayOfNumbersString = stringOfNumbers.split(" ");
    Integer[] arrayOfNumbers = new Integer[n];

    for( int i = 0; i < arrayOfNumbersString.length; i++) {
        arrayOfNumbers[i] = Integer.valueOf(arrayOfNumbersString[i]);
    }
    HashSet<ArrayList<Integer>> answerArray = new HashSet<>();
    ArrayList<Integer> answer = new ArrayList<>();
    comboSum(0, arrayOfNumbers, answerArray, answer, target);

    answerArray.stream().forEach(x->System.out.println(x));
}

    private static void comboSum(int index, Integer[] arrayOfNumbers, HashSet<ArrayList<Integer>> answerArray, ArrayList<Integer> answer, int target) {
        if(index==arrayOfNumbers.length){
            // System.out.println(answer);

            if(target==0)
                answerArray.add(new ArrayList<>(answer)); // Add a copy of the subset to the answerArray
            return;
        }
        if(arrayOfNumbers[index]<=target) {
            answer.add(arrayOfNumbers[index]);
            comboSum(index, arrayOfNumbers, answerArray, answer, target-arrayOfNumbers[index]);
            answer.remove(answer.size()-1);
        }
        comboSum(index +1, arrayOfNumbers, answerArray, answer, target);
    }

}
