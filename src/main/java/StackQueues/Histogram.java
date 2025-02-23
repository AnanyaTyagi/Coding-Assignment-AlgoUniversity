package StackQueues;

import java.util.*;

public class Histogram {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int array[] = new int[N];
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();


        for(int i = 0; i < N ; i++) {
            array[i] = sc.nextInt();
        }

        int leftArray[] = new int[N];
        int rightArray[] = new int[N];

        //leftArray
        for(int i = 0; i < N ; i++) {
            if(i==0){
                leftStack.push(0);
                leftArray[0]= 1;
                continue;
            }

            if(leftStack.empty()){
                leftArray[i]= i+1;
                leftStack.push(i);
            } else if(array[leftStack.peek()] < array[i]){
                leftArray[i] = i - leftStack.peek();
                leftStack.push(i);
            } else {
               while(array[leftStack.peek()] >=array[i]){
                    leftStack.pop();
                    if(leftStack.empty())
                        break;
               }

                if(leftStack.empty()){
                    leftArray[i]= i+1;
                    leftStack.push(i);
                } else if(array[leftStack.peek()] < array[i]){
                    leftArray[i] = i - leftStack.peek();
                    leftStack.push(i);
                }
            }
        }

        //rightArray
        for(int i = N-1; i >-1 ; i--) {
            if(i==N-1){
                rightStack.push(N-1);
                rightArray[N-1]= 1;
                continue;
            }

            if(rightStack.empty()){
                rightArray[i]= N-i;
                rightStack.push(i);
            } else if(array[rightStack.peek()] < array[i]){
                rightArray[i] = rightStack.peek() - i;
                rightStack.push(i);
            } else {
                while(array[rightStack.peek()] >=array[i]){
                    rightStack.pop();
                    if(rightStack.empty())
                        break;
                }

                if(rightStack.empty()){
                    rightArray[i]= N-i;
                    rightStack.push(i);
                } else if(array[rightStack.peek()] < array[i]){
                    rightArray[i] = rightStack.peek() - i;
                    rightStack.push(i);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N ; i++) {
           // System.out.print(leftArray[i] + " ");
           // System.out.println(rightArray[i]);
                list.add((leftArray[i]+rightArray[i]-1)*array[i]);
        }
        System.out.print(Collections.max(list));

    }
}

//    public static void largestRectangleArea(int[] heights){
//        Stack<Integer> st = new Stack<>();
//        int maxArea = 0;
//        st.push(-1);
//        for(int i=0;i<=heights.length;i++)
//        {
//            int val = i==heights.length ? 0 : heights[i];
//            while(st.peek() != -1 && heights[st.peek()] >= val)
//            {
//                int rightMin = i;
//                int height = heights[st.pop()];
//                int leftMin = st.peek();
//                maxArea = Math.max(maxArea,height*(rightMin-leftMin-1));
//            }
//            st.push(i);
//        }