package ArraysQuestions;

import java.util.HashSet;

public class ZeroSumSubArray {

    public boolean zeroSumSubarray(int[] nums) {
        // Write your code here.
        HashSet<Integer> sums = new HashSet<Integer>();
        int currentSum = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]==0)
                return true;
            currentSum+=nums[i];
            if(sums.contains(currentSum) || currentSum==0){
                return true;
            }
            sums.add(currentSum);
        }
        return false;
    }
}
