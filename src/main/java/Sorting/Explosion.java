package Sorting;

import java.util.*;

public class Explosion {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = s.nextInt();
            if (!map.containsKey(num)) {
                map.put(num, 1);
                list.add(num);
            } else {
                int count = map.get(num);
                map.put(num, ++count);
            }
        }

        Collections.sort(list);
  // System.out.println(list);
        int countOfExploded = 0;
        int maxExploded = 0;

        for (int i = 0; i < list.size(); i++) {
            int frontPointer = i + 1;
            int backPointer = i - 1;
            countOfExploded = map.get(list.get(i));
            int currentExplodedIndex = list.get(i);

            //for explosives behind the current explosion
            if (i != 0) {
                int t = 1;
                while (backPointer > -1) {
                   // System.out.println("backPointer "+ backPointer);
                    if(currentExplodedIndex-t>list.get(backPointer)){
                        break;
                    } else if(currentExplodedIndex-t==(list.get(backPointer))){
                        currentExplodedIndex= list.get(backPointer);
                        countOfExploded+=map.get(list.get(backPointer));
                        t++;
                        backPointer--;

                    } else {

                        if(backPointer== 0) {
                            countOfExploded+=map.get(list.get(backPointer));
                            break;
                        }
                        if(currentExplodedIndex-t>list.get(backPointer-1)) {
                            t++;
                            currentExplodedIndex = list.get(backPointer);
                        }

                        countOfExploded+=map.get(list.get(backPointer));

                        backPointer--;

                    }
                }
            }
            //for explosives in front of the current explosion
            currentExplodedIndex = list.get(i);
            if (i != N-1) {
                int t = 1;
                while (frontPointer < list.size()) {

                    if(currentExplodedIndex+t<list.get(frontPointer)){
                        break;
                    } else if(currentExplodedIndex+t==(list.get(frontPointer))){

                        currentExplodedIndex= list.get(frontPointer);
                        countOfExploded+=map.get(list.get(frontPointer));
                        t++;
                      //  System.out.println("l1frontPointer "+ frontPointer + " t: "+ t +" currentExploded: "+ currentExplodedIndex);

                        frontPointer++;

                    } else {

                        if(frontPointer== list.size()-1) {
                            countOfExploded+=map.get(list.get(frontPointer));
                            break;
                        }
                        if(currentExplodedIndex+t<list.get(frontPointer+1)) {
                            currentExplodedIndex = list.get(frontPointer);
                            t++;
                        }
                        countOfExploded+=map.get(list.get(frontPointer));

                       // System.out.println("l2frontPointer "+ frontPointer + " t: "+ t +" currentExploded: "+ currentExplodedIndex);
                        frontPointer++;


                    }
                }
            }
            maxExploded = Math.max(countOfExploded, maxExploded);

        }

     System.out.print(maxExploded);
    }
}
//44
//69 55 48 24 5 28 41 25 20 3 4 44 70 42 1 6 43 47 61 73 56 63 75 79 45 60 77 19 76 58 17 9 33 30 29 10 72 26 31 8 39 22 71 54