package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueWindow {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        Integer M = s.nextInt();

        int[] array1 = new int[N];
        int[] array2 = new int[M];
        Set<Integer> set = new HashSet<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < N; i++) {
            array1[i] = s.nextInt();
            map.put(array1[i], i);
        }
    }
}
