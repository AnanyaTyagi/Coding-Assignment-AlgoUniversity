package StackQueues;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        String[] expressionArray = expression.split(" ");
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        if(expressionArray.length==0) {
            System.out.print("");
            System.exit(0);
        }

        for(int i = 0; i < expressionArray.length; i++){

            if(expressionArray[i].equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            } else if(expressionArray[i].equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            } else if(expressionArray[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else if(expressionArray[i].equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if(-1<Integer.valueOf(expressionArray[i]) && Integer.valueOf(expressionArray[i])<10){
                stack.push(Integer.valueOf(expressionArray[i]));
            }

        }
        System.out.print((int)stack.pop());
    }
}
