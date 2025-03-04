package ArraysQuestions;

import java.util.Arrays;
//Given an array of n unique integers where each element in the array is in range [1, n]. The array has all distinct
//        elements and size of an array is (n-2).
//        Hence Two numbers from the range are missing from this array. Find the two missing numbers.


public class MissingNumbers {

    public int[] missingNumbers(int[] nums) {
        int solutionsXOR = 0;
        for(int i = 0;i<nums.length+3;i++){
            solutionsXOR^=i;
            if(i<nums.length){
                solutionsXOR^=nums[i];
            }
        }
        int[] solutions = new int[2];
        int setBit = solutionsXOR & -solutionsXOR;

        for(int i = 0;i<nums.length+3;i++){
            //if bit is not set we craete a xor of all such numbers
            if((i& setBit) == 0){
                solutions[0] ^=i;
            } else {
                solutions[1]^=i;
            }

            if(i<nums.length){
                if((nums[i] & setBit)==0){
                    solutions[0]^=nums[i];
                } else {
                    solutions[1]^=nums[i];
                }
            }

        }
        Arrays.sort(solutions);
        return solutions;
    }
}
