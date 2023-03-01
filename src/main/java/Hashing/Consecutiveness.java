package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Consecutiveness {

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        Integer N = Integer.parseInt(str);
        String[] st = bufferedReader.readLine().split(" ");
        // HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = new int[N];
        int maxSize = 0;
        int totalSize = 0;

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st[i]);
            set.add(array[i]);
        }

        for (int i = 0; i < N; i++) {
           if(set.contains(array[i]-1)) {
               totalSize=0;
               continue;
           }
           else{

               totalSize=0;
               totalSize++;
               int num = array[i];
              // System.out.println(num);

               while(set.contains(num+1)){
                   totalSize++;
                   num++;
               }
           }
           i++;
           maxSize = Math.max(totalSize, maxSize);
        }

         System.out.println(maxSize);


//            Arrays.sort(array);
//        for (int i = 0; i < N; i++) {
//            map.put(array[i], i);
//        }
//
//        if(N==0){
//            System.out.println(0);
//            System.exit(0);
//        }
//
//        if(N==1){
//            System.out.println(1);
//            System.exit(0);
//        }
//
//        int index = 0;
//            int num= array[0];
//            boolean flag = true;
//            while (index < N) {
//
//                if(map.containsKey(num+1)){
//                    totalSize++;
//                    num++;
//                    if(index == 0 || flag ==false) {
//                        totalSize++;
//                        flag = true;
//                    }
//                    index=map.get(num);
//                } else {
//                    maxSize = Math.max(totalSize, maxSize);
//                    if(index+1 ==N)
//                        break;
//                    num = array[index+1];
//                    totalSize = 0;
//                    flag = false;
//                    index++;
//                }
//            }
//        }

    }
}
