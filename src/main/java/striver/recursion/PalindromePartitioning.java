package striver.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromePartitioning {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String string = s.nextLine();
        s.close();
        ArrayList<ArrayList<String>> answerList = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        palindromePartitioning(string, 0, answerList, list);
        answerList.stream().forEach(x -> System.out.println(x));

    }

    public static void palindromePartitioning(String string, int index, ArrayList<ArrayList<String>> answerList, ArrayList<String> list) {
        if (index == string.length()) {
            answerList.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < string.length(); i++) {
            if (checkPalindrome(string, index, i)) {
               // System.out.println("adding "+ string.substring(index, i + 1));
                list.add(string.substring(index, i + 1));
                palindromePartitioning(string, i+1, answerList, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean checkPalindrome(String s, int start, int end) {

        while (start <= end) {
            if (s.charAt(start++) != (s.charAt(end--))) {
                return false;
            }
        }
        return true;
    }

}
