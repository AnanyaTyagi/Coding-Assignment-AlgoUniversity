package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MatrixToList {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] adjMatrix = new int[n+1][n+1];
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 1; i<=n; i++){
            List<Integer> listForNode = new ArrayList<>();
            for(int j = 1; j<=n; j++){
                adjMatrix[i][j] = scanner.nextInt();
                if(adjMatrix[i][j] == 1)
                listForNode.add(j);
            }
            adjList.add(listForNode);
        }

        for(int i = 0; i<n; i++){
            System.out.print(i+1 + ": ");
            List<Integer> list = adjList.get(i);
            for(int j = 0; j< list.size(); j++){
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}
