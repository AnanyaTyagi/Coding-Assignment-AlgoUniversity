package striver.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class AllPossibleSubsetsWithoutDuplicate {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String noOfElements = s.nextLine();
        String stringOfNumbers = s.nextLine();
        s.close();
        Integer n = Integer.valueOf(noOfElements);
        String[] arrayOfNumbersString = stringOfNumbers.split(" ");
        Integer[] arrayOfNumbers = new Integer[n];

        for( int i = 0; i < arrayOfNumbersString.length; i++) {
            arrayOfNumbers[i] = Integer.valueOf(arrayOfNumbersString[i]);

        }
        HashSet<ArrayList<Integer>> answerArray = new HashSet<>();
        ArrayList<Integer> answer = new ArrayList<>();


        sumOfSubsets(0, arrayOfNumbers, answerArray, answer);
        answerArray.stream().forEach(x->System.out.println(x));
    }

    private static void sumOfSubsets(int index, Integer[] arrayOfNumbers, HashSet<ArrayList<Integer>> answerArray, ArrayList<Integer> answer) {
        if(index==arrayOfNumbers.length){
            answerArray.add(new ArrayList<>(answer)); // Add a copy of the subset to the answerArray
            return;
        }
        answer.add(arrayOfNumbers[index]);
        sumOfSubsets(index+1, arrayOfNumbers, answerArray, answer);
        answer.remove(answer.size()-1);
        sumOfSubsets(index +1, arrayOfNumbers, answerArray, answer);
    }

}
