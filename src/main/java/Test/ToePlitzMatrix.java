package Test;

import java.util.Scanner;

public class ToePlitzMatrix {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        Integer M = s.nextInt();

        int[][] array = new int[N][M];

        if(N == 0 || M ==0 ){
            System.out.println(0);
            System.exit(0);
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = s.nextInt();
            }
        }

        boolean rowFlag = true;
        boolean colFlag = true;

        if (N == 1 || M == 1) {
            System.out.println(1);
            System.exit(0);
        } else {

            for(int i =1 ; i <= N-1 ; i++) {
                int rowIndex = i;
                int colIndex = 1;
                while(rowIndex!= N){

                    if(array[rowIndex][colIndex]!= array[rowIndex-1][colIndex-1]){
                        rowFlag = false;
                        break;
                    }
                    rowIndex++;
                    colIndex++;
                    if(colIndex>=M-1)
                       break;
                }
                if(rowFlag == false) {
                    break;
                }
            }

            if(rowFlag == true) {
                for(int j =2 ; j < M-1 ; j++) {
                    int rowIndex = 1;
                    int colIndex = j;
                    while(colIndex!= M){
                        if(array[rowIndex][colIndex]!= array[rowIndex-1][colIndex-1]){
                            colFlag = false;
                            break;
                        }
                        rowIndex++;
                        colIndex++;

                        if(rowIndex>=N-1)
                            break;
                    }
                    if(colFlag == false)
                        break;
                }

                if(colFlag == false) {
                    System.out.println(0);
                    System.exit(0);
                }
            } else {
                System.out.println(0);
                System.exit(0);
            }

        }

        System.out.println(1);
    }
}
