package ArraysQuestions;

import java.util.HashMap;
import java.util.Map;

public class LongestRange {
    //https://leetcode.com/problems/longest-consecutive-sequence/description/
    //Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    //
    //You must write an algorithm that runs in O(n) time.
    public static int[] largestRange(int[] array) {
        int[] results = new int[2];
        int longestLength = 0;
        HashMap<Integer, Boolean> nums = new HashMap<>();
        for(int i = 0;i<array.length;i++){
            nums.put(array[i], true);
        }

        for(int num:array){
            //already processed number is removed
            if(!nums.containsKey(num)){
                continue;
            }
            nums.put(num, false);
            int left = num-1;
            int right= num+1;
            int currentLength = 1;//if single element
            while(nums.containsKey(left)){
                nums.put(left, false);
               left--;
                currentLength++;
            }
            while(nums.containsKey(right)){
                nums.put(right, false);
                right++;
                currentLength++;
            }
if(currentLength>longestLength) {
longestLength = currentLength;
results = new int[]{left + 1, right - 1};
}

        }
        return results;
    }
}
