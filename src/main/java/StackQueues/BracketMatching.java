package StackQueues;

import java.util.Scanner;
import java.util.Stack;

public class BracketMatching {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine();
        String[] bracketArray = brackets.split("");
        int[] result = new int[bracketArray.length];
        Stack<Integer> stack = new Stack<>();


        for(int i = 0; i < bracketArray.length; i++){
            result[i] = -1;

            if(bracketArray[i].equals("(")){
               // System.out.println("****************");
                stack.push(i);
            } else {
                if(stack.empty()) {
                    continue;
                }
               // System.out.println("########################");

                int temp = stack.pop();
                result[temp] = i;
                result[i] = temp;
            }
        }

        for(int i = 0; i < bracketArray.length; i++) {
            System.out.print(result[i]+ " ");
        }
    }
}
