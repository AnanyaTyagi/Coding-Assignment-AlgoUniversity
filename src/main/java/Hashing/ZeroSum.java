package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ZeroSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        Integer N = Integer.parseInt(str);
        String[] st = bufferedReader.readLine().split(" ");
        int[] arrayPrefixSum = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st[i]);
            sum+=array[i];
            arrayPrefixSum[i]= sum;
            if(!map.containsKey(arrayPrefixSum[i])) {
                map.put(arrayPrefixSum[i], i);
            } else{
                System.out.print("YES");
                System.exit(0);
            }
        }

        System.out.print("NO");
    }
}
