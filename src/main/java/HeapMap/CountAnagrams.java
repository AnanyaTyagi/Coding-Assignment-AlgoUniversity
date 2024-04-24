package HeapMap;

import java.util.Scanner;

public class CountAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();

        int sLength = s.length();
        int tLength = t.length();

        if (sLength < tLength) {
            System.out.println(0);
            return;
        }

        int[] freq = new int[26];
        int[] actual = new int[26];
        int res = 0;

        // Populate the frequency array for string T
        for (char c : t.toCharArray()) {
            actual[c - 'a']++;
        }

        // Initialize the frequency array for the first window of string S
        for (int i = 0; i < tLength; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        // Check if the first window is an anagram
        if (isValid(freq, actual)) {
            res++;
        }

        // Check each window of string S for anagrams of string T
        for (int i = tLength; i < sLength; i++) {
            // Update the frequency array for the current window
            freq[s.charAt(i) - 'a']++;
            if (i - tLength >= 0) {
                freq[s.charAt(i - tLength) - 'a']--;
            }

            // Check if the current window is an anagram of string T
            if (isValid(freq, actual)) {
                res++;
            }
        }

        System.out.println(res);
    }

    // Function to check if two frequency arrays are equal
    private static boolean isValid(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
