package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueWindow {
    public static void main(String[] args) throws IOException {
       // Scanner s = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferedReader.readLine().split(" ");
        Integer N = Integer.parseInt(str[0]);
        Integer K = Integer.parseInt(str[1]);
        String[] st = bufferedReader.readLine().split(" ");

        int[] array = new int[N];
        int[] map = new int[101];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st[i]);
        }

        int distinctCount = 0;
        for (int i = 0; i < K; i++) {
            if (map[array[i]] == 0) {
                map[array[i]] = 1;
                distinctCount++;
             }
            else{
                int count = map[array[i]];
                map[array[i]]= ++count;
            }
        }
       System.out.print(distinctCount + " ");

        for(int i = K; i<N; i++) {
          //  System.out.println(map);
            if(map[array[i-K]] > 1){
              int count= map[array[i-K]];
              map[array[i-K]]= --count;
            } else{
               map[array[i-K]]=0;
               distinctCount--;
            }
            if(map[array[i]]==0) {
                map[array[i]] = 1;
                distinctCount++;
            }
            else{
                int count = map[array[i]];
                map[array[i]]= ++count;
            }
            System.out.print(distinctCount + " ");
        }
    }
}
