package ArraysQuestions;

public class LongestSubArraySum {

    public int[] longestSubarrayWithSum(int[] array, int targetSum) {
        // Write your code here.
        int[] indices = new int[]{};
        int currentSubarraySum = 0;
        int startingIndex = 0;
        int endingIndex = 0;
        while(endingIndex <array.length){
            currentSubarraySum +=array[endingIndex];
            while(startingIndex < endingIndex && currentSubarraySum > targetSum){
                currentSubarraySum-=array[startingIndex];
                startingIndex++;
            }


            if(currentSubarraySum == targetSum){
                if(indices.length==0 || indices[1]-indices[0]<endingIndex - startingIndex){
                    indices = new int[]{startingIndex, endingIndex};
                }
            }
            endingIndex++;
        }
        return indices;
    }
}
