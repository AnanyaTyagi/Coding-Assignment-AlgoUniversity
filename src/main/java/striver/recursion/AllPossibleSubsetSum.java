package striver.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class AllPossibleSubsetSum {
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
        Integer[] answerArray = new Integer[(int) Math.pow(2, n)];

        sumOfSubsets(0, arrayOfNumbers, answerArray,0, 0);
        System.out.println();
      Arrays.sort(answerArray);
        Arrays.stream(answerArray).forEach(x->System.out.print(x+ " "));
    }

    private static void sumOfSubsets(int index, Integer[] arrayOfNumbers, Integer[] answerArray, int sum, int indexOfAnswer) {
        System.out.println(indexOfAnswer + " " +(indexOfAnswer+1<<index));

        if(index==arrayOfNumbers.length){

           answerArray[indexOfAnswer] = sum;
            return;
        }
        answerArray[indexOfAnswer] = sum;
        sumOfSubsets(index+1, arrayOfNumbers, answerArray,sum, indexOfAnswer);
        sumOfSubsets(index +1, arrayOfNumbers, answerArray,sum+arrayOfNumbers[index], indexOfAnswer+(1<<index));

    }
}

//public class AllPossibleSubsetSum {
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        String noOfElements = s.nextLine();
//        String stringOfNumbers = s.nextLine();
//        s.close();
//        Integer n = Integer.valueOf(noOfElements);
//        String[] arrayOfNumbersString = stringOfNumbers.split(" ");
//        Integer[] arrayOfNumbers = new Integer[n];
//
//        for (int i = 0; i < arrayOfNumbersString.length; i++) {
//            arrayOfNumbers[i] = Integer.valueOf(arrayOfNumbersString[i]);
//        }
//        Integer[] answerArray = new Integer[(int) Math.pow(2, n)];
//
//        sumOfSubsets(0, arrayOfNumbers, answerArray, 0);
//
//        System.out.println("Sum of all possible subsets:");
//        for (int i = 0; i < answerArray.length; i++) {
//            System.out.println(answerArray[i]);
//        }
//    }
//
//    private static void sumOfSubsets(int index, Integer[] arrayOfNumbers, Integer[] answerArray, int sum) {
//        if (index == arrayOfNumbers.length) {
//            return;
//        }
//
//        // Include current element
//        //if 0 is repeated but inde value will be 0, 1, 2 , 3 so..0+1, 0+2, 0+ 3 ..conatinig single element subsets
//        answerArray[(1 << index)] = sum + arrayOfNumbers[index];
//        sumOfSubsets(index + 1, arrayOfNumbers, answerArray, sum + arrayOfNumbers[index]);
//
//        // Exclude current element
//        sumOfSubsets(index + 1, arrayOfNumbers, answerArray, sum);
//    }
//}