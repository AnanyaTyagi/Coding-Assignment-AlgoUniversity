package ArraysQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreasureRoomEasyV2 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String numbers = s.nextLine();
        String stringOfNumbers = s.nextLine();
        s.close();
        String[] nAndW = numbers.split(" ");
        Integer n = Integer.valueOf(nAndW[0]);
        Integer w = Integer.valueOf(nAndW[1]);
        String[] arrayOfNumbersString = stringOfNumbers.split(" ");
        List<Integer> arrayOfNumbers = new ArrayList<>();
        Map<Integer, Integer> mapOfSubtraction = new HashMap<>();
        Map<Integer, Integer> mapOfCount = new HashMap<>();

        arrayOfNumbers.add(-99999);
            for (int i = 0; i < n; i++) {
                arrayOfNumbers.add(Integer.valueOf(arrayOfNumbersString[i]));
                mapOfSubtraction.put(w - arrayOfNumbers.get(i+1),arrayOfNumbers.get(i+1));
                if(!mapOfCount.containsKey(arrayOfNumbers.get(i+1))) {
                    mapOfCount.put(arrayOfNumbers.get(i+1), 1);
                } else {
                    int count = mapOfCount.get(arrayOfNumbers.get(i+1));
                    mapOfCount.put(arrayOfNumbers.get(i+1),++count);
                }
            }
    System.out.println(mapOfSubtraction);
       System.out.println(mapOfCount);

        boolean flag = false;

        for (int i = 1; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int sum = arrayOfNumbers.get(i) + arrayOfNumbers.get(j);
                if(arrayOfNumbers.get(i) == arrayOfNumbers.get(j)  && mapOfSubtraction.containsKey(sum) && mapOfSubtraction.get(sum)==arrayOfNumbers.get(i) && mapOfCount.get(w-sum)>=3){
                    flag=true;
                    List<Integer> subList = arrayOfNumbers.subList(j+1, n+1);
                    int indexOfThird = subList.indexOf(arrayOfNumbers.get(j));
                    System.out.println(subList);

                    System.out.print(i+" "+j+" "+(indexOfThird+j+1));

                }

                if((arrayOfNumbers.get(i) != arrayOfNumbers.get(j)  && mapOfSubtraction.containsKey(sum) && mapOfSubtraction.get(sum)!=arrayOfNumbers.get(i) && mapOfSubtraction.get(sum)!=arrayOfNumbers.get(j) && mapOfCount.get(w-sum)>=1)||(arrayOfNumbers.get(i) == arrayOfNumbers.get(j) && mapOfSubtraction.get(sum)!=arrayOfNumbers.get(i) && mapOfCount.get(w-sum)>=1)
                        || (arrayOfNumbers.get(i) != arrayOfNumbers.get(j) && mapOfSubtraction.get(sum)==arrayOfNumbers.get(i))
                        || (arrayOfNumbers.get(i) != arrayOfNumbers.get(j) && mapOfSubtraction.get(sum)==arrayOfNumbers.get(j))
                        && mapOfSubtraction.containsKey(sum)){
                    flag=true;
                    List<Integer> subList = arrayOfNumbers.subList(j+1, n+1);
                    int indexOfThird = subList.indexOf(w-sum);
                    System.out.print(i+" "+j+" "+(indexOfThird+j+1));
                }
                if(flag == true)
                    break;

            }
            if(flag == true)
                break;
        }

        if(flag == false)
        System.out.println(-1);
    }
}

///real things than work
//import java.util.*;
//
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int w = sc.nextInt();
//        int[] a = new int[n];
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<n;i++){
//            a[i] = sc.nextInt();
//            map.put(a[i],i);
//        }
//
//        boolean found = false;
//        Pair it = new Pair(-1,-1);
//        int p=0;
//        for(;p<n;p++){
//            it = twoSum(map,w-a[p],n,a,p);
//            if(it.x!=-1 && w == a[p]+a[it.x]+a[it.y] && p != it.x && p!= it.y && it.y != it.x)
//            {found = true;break;}
//        }
//        if(found)
//        {
//            System.out.println((p+1)+" "+(it.x+1)+" "+(it.y+1));
//        }
//        else
//            System.out.println(-1);
//    }
//
//    static class Pair{
//        int x,y;
//        Pair(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    static Pair twoSum(Map<Integer,Integer> map, int s,int n, int[] a, int i){
//        int x=0; boolean contains = false;
//        for(;x<n;x++){
//            if(x!=i && map.containsKey(s-a[x]))
//            {
//            contains = true;
//            break;
//            }
//        }
//        if(contains && x!=map.get(s-a[x])){
//            return new Pair(x,map.get(s-a[x]));
//        }
//        else
//            return new Pair(-1,-1);
//    }
//}