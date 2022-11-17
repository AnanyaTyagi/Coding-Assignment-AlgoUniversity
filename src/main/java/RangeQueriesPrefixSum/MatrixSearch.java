package RangeQueriesPrefixSum;

import java.util.Scanner;

public class MatrixSearch {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        Integer M = s.nextInt();
        Integer Q = s.nextInt();
        int[][] array = new int[N][M];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                array[i][j] = s.nextInt();
            }
        }

        for(int i = 0; i<Q; i++) {
            binarySearch(array, s.nextInt(), N, M);
        }

    }

    static void binarySearch(int[][] matrix, int target, int N, int M) {
        int l = 0;
        int r = N*M;

        while(l<=r){
            int mid = l + (r-l)/2;
            int row = mid / M;
            int col = mid % M;

            if(matrix[row][col] == target) {
                System.out.print(row + " " + col);
                System.out.println();
                break;
            }

            if(matrix[row][col] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }


//        int l = 0;
//        int r = N*M;
//
//        while(l<=r){
//            int mid = l + (r-l)/2;
//            int row = mid / M;
//            if(mid % M == 0 && mid > M)
//                row = row-1;
//            int col = (mid % M)-1;
//            if(mid== 0)
//                col = 0;
//            if(col==-1 && mid >= M)
//                col = M-1;
//            System.out.println(row + " "+ mid+ " " + col);
//
//            if(matrix[row][col] == target) {
//               System.out.print(row + " " + col);
//               System.out.println();
//               break;
//            }
//
//            if(matrix[row][col] < target) {
//                 l = mid + 1;
//            } else {
//                r = mid - 1;
//            }

        }

}
