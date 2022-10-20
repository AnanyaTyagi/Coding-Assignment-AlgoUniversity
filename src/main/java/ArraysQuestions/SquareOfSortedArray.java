package ArraysQuestions;

import java.util.Scanner;

public class SquareOfSortedArray {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String noOfElements = s.nextLine();
        String stringOfNumbers = s.nextLine();
        s.close();

        Integer n = Integer.valueOf(noOfElements);
        String[] arrayOfNumbersString = stringOfNumbers.split(" ");
        Integer[] sortedArray = new Integer[n];

        Integer[] arrayOfNumbers = new Integer[n];

        for( int i = 0; i < arrayOfNumbersString.length; i++) {
            arrayOfNumbers[i] = Integer.valueOf(arrayOfNumbersString[i]);

        }
        int smallerIndex = 0;
        int largerIndex = n - 1;
        for( int idx = n-1; idx>=0 ; idx--){
            if(Math.abs(arrayOfNumbers[smallerIndex]) > Math.abs(arrayOfNumbers[largerIndex])) {
                sortedArray[idx] =  arrayOfNumbers[smallerIndex] * arrayOfNumbers[smallerIndex];
                smallerIndex ++;
            } else {
                sortedArray[idx] =  arrayOfNumbers[largerIndex] * arrayOfNumbers[largerIndex];
                largerIndex --;
            }
        }

        for( int i = 0; i < arrayOfNumbersString.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }

    }
}
