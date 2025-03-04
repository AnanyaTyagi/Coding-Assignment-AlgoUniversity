package ArraysQuestions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinRewards {

//    Today’s problem is titled Min Rewards. A teacher has an array of student scores, and the teacher must purchase rewards to give to the students based on their score. The amount of rewards must follow 2 criteria:
//
//    Each student must have at least one reward.
//    The higher ranked student of two adjacent students must have more rewards than the other.
//    The goal is to find the minimum number of rewards to purchase. You can also find the problem on LeetCode but there is a slight difference between the two in that AlgoExpert’s prompt uses only distinct integers in the input array while LeetCode’s prompt allows for duplicate scores. I will cover how to adapt to the LeetCode version in the end.
//
//
    //TODO https://leetcode.com/problems/candy/description/

    public static int minRewards(int[] scores) {
        // Write your code here.
        int[] rewards  = new int[scores.length];
        Arrays.fill(rewards, 1);
        for(int i = 1; i<scores.length;i++){
            if(scores[i]>scores[i-1]){
                rewards[i] = rewards[i-1]+1;
            }
        }
        for(int i = scores.length-2; i>=0;i--){
            if(scores[i]>scores[i+1]){
                rewards[i] = Math.max(rewards[i], rewards[i+1]+1);
            }
        }
        return IntStream.of(rewards).sum();
    }
}
