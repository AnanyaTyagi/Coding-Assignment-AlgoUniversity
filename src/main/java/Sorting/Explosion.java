package Sorting;

import java.util.*;

public class Explosion {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        List<Integer> list = new ArrayList<>();
        int array[] = new int[N];
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i <N; i++) {
            array[i] = s.nextInt();
            map.put(array[i], false);
        }
        Arrays.sort(array);
        for (int i = 0; i <N; i++) {
            list.add(array[i]);
        }

        int maxExplosives = 0;
        for (int i = 0; i < N; i++) {
            int totalExploded = 0;
            int t= 1;

            //where explosion starts or index of next to be exploded
            int currIndex = i;

            //to traverse remaining explosives
            int k = 0;

            //a flag to check if explosions stopped
            boolean flag = true;
            while(flag){
                if(map.containsKey(array[currIndex] + t)){
                    //not including last exploded
                    totalExploded+=list.indexOf(array[currIndex] + t)-currIndex;
                    currIndex=list.indexOf(array[currIndex] + t);
                    k = currIndex;
                    t++;
                } else {

                    if((array[currIndex] + t)>array[currIndex]){
                        totalExploded++;
                        flag = false;
                        break;
                    } else {

                    }

                }
                if(currIndex==N-1)
                    flag = false;
            }
            maxExplosives = Math.max(totalExploded, maxExplosives);
        }
        System.out.println(maxExplosives);
    }
}
