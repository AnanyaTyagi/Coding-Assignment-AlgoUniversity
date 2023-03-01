package StackQueues;

import java.util.Scanner;
import java.util.Stack;

public class NearestLargestNumbers {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int array[] = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N ; i++) {
            array[i] = sc.nextInt();
            if(stack.empty()){
                System.out.print("-1 ");
            } else if(stack.peek()>array[i]){
                   System.out.print(stack.peek() + " ");

            } else{
                int lastPopped = -1;
                while(stack.peek()<=array[i]) {
                   lastPopped= stack.pop();
                    if(stack.empty()){
                        break;
                    }
                }
                if(stack.empty()) {
                    System.out.print(-1 + " ");
                }
                else {
                    System.out.print(stack.peek() + " ");
                }
            }
            stack.push(array[i]);
        }
    }
}
