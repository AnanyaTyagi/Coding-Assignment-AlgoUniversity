package Test;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArray7 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = s.nextInt();
        }

        int maxLength = 0;
        long currentSum = 0;
        HashMap<Long, Integer> remainderMap =  new HashMap<>();
        for (int i = 0; i < N; i++) {
            currentSum+= array[i];

            long mod =(currentSum % 7);
            if(mod == 0){
                if(i+1 > maxLength)
                    maxLength = i+1;
            } else{
                if(remainderMap.containsKey(mod)) {
                   int length = i -  remainderMap.get(mod);
                   if(length > maxLength)
                       maxLength = length;
                } else
                remainderMap.put(mod, i);
            }

        }
        System.out.println(maxLength);
    }
}

