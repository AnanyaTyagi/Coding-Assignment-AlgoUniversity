package striver.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CombinationSumRepeatElementsNotAllowed {

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

        for (int i = 0; i < arrayOfNumbersString.length; i++) {
            arrayOfNumbers[i] = Integer.valueOf(arrayOfNumbersString[i]);
        }
        HashSet<ArrayList<Integer>> answerArray = new HashSet<>();
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arrayOfNumbers);
        comboSum(0, arrayOfNumbers, answerArray, answer, target);
        answerArray.stream().forEach(x -> System.out.println(x));
    }

    private static void comboSum(int index, Integer[] arrayOfNumbers, HashSet<ArrayList<Integer>> answerArray, ArrayList<Integer> answer, int target) {
            if (target == 0) {
                answerArray.add(new ArrayList<>(answer)); // Add a copy of the subset to the answerArray
                return;
            }

        for (int i = index; i < arrayOfNumbers.length; i++) {
            if (i > index && arrayOfNumbers[i] == arrayOfNumbers[i - 1]) continue;
            if (arrayOfNumbers[i] > target) break;

            answer.add(arrayOfNumbers[i]);
            comboSum(i + 1, arrayOfNumbers, answerArray, answer, target - arrayOfNumbers[i]);
            answer.remove(answer.size() - 1);
        }
    }

}
