package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetSum {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
      //  List<Long> diffList = new ArrayList<Long>();
        //long total = 0;
        long sum1 = 0, sum2 = 0;
        for(int i = 0; i<n; i++){
            list.add(sc.nextInt());
           // total+=list.get(i);
        }
     //  minDiffBetweenSubsets(list, diffList, total, list.size(), 0);
      //  System.out.println(Collections.min(diffList));
       System.out.println(subsetSum(0, list, sum1, sum2));
    }

    private static long subsetSum(int i, List<Integer> list, long sum1, long sum2){
        if(list.size()==i)
            return Math.abs(sum1-sum2);
        long p = subsetSum(i+1, list, sum1 + list.get(i), sum2);
        long q = subsetSum(i+1, list, sum1, sum2 + list.get(i));
        return Math.min(p, q);
    }

//    private static void minDiffBetweenSubsets(List<Integer> list, List<Long> diffList,long total, int size , int totalCurrent) {
//        if(total==totalCurrent)
//            return;
//        for(int i = 0; i< list.size();i++){
//            int currentNum = list.get(i);
//            totalCurrent+= currentNum;
//            list.remove(i);
//            if(i!= list.size())
//            diffList.add(total - totalCurrent);
//            minDiffBetweenSubsets(list, diffList, total, size, totalCurrent);
//            list.add(i, currentNum);
//            totalCurrent-=currentNum;
//        }
//    }
}
