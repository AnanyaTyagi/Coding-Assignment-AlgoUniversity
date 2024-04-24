package HeapMap;

import java.util.HashMap;
import java.util.Scanner;

public class RecrutuingSoldiers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] sArr = s.split(" ");
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(sArr[i]); // Insert value Longo min heap
            int freq = 0;
            if (map.containsKey(arr[i])) {
                freq = map.get(arr[i]);
                maxFreq = Math.max(maxFreq, freq + 1);
                map.put(arr[i], freq + 1);
            } else {

                maxFreq = Math.max(maxFreq, 1);

                map.put(arr[i], 1);
            }

        }

        System.out.println(Math.max(0, (2* maxFreq-N)/2));
    }

}
