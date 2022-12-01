package Test;

import java.util.Arrays;
import java.util.Scanner;

public class NumerOfTriangles {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int array[] = new int[N];

        for(int i = 0; i<N;i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);

    int count = 0;
    for(int i = 0; i< N-2; ++i){
        int k = i+2;
        for(int j = i+1; j<N ; ++j){
            while(k<N && (array[i] + array[j] )> array[k]){
                ++k;
            }

            if(k>j){
                count += k-j-1;
            }
        }
    }

    System.out.println(count);

    }

}
