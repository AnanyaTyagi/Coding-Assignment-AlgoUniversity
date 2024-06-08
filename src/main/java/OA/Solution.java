package OA;

import java.util.Scanner;
import java.util.*;

        class Solution {
            public String solution(String S, int K) {
                // Implement your solution here

                char[] arr = S.toCharArray();
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                int countOf5 = 0;
                for(int i = 0; i <arr.length;i++){
                    if(map.containsKey(Integer.valueOf(arr[i])))
                        map.put(Integer.valueOf(arr[i]), map.get(Integer.valueOf(arr[i]))+1);
                    else
                        map.put(Integer.valueOf(arr[i]), 1);


                }
//  List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//   Collections.sort(list,new Comparator< Map.Entry<String, Integer>>(){
//       return o1.getValue().compareTo(o2.getValue());
//   });

                if(!(map.get(5)==null)){
                    int difference= S.length()- map.get(5);
                    if(difference<K)
                        return  "IMPOSSIBLE";
                }

                char solution[] = new char[arr.length];
                for(int i = 0; i <arr.length;i++){
                    if(K>0){
                        if(Integer.valueOf(arr[i])<5)
                            solution[i]=5;
                    } else{
                        solution[i] = arr[i];
                        break;
                    }

                    K--;
                }

                return new String(solution);
            }
        }
