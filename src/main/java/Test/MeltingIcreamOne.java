package Test;

import java.util.*;

public class MeltingIcreamOne {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int srci = 0 ;
        int srcj = 0;
        int desti = 0;
        int destj = 0;

        String[][] adjMatrix = new String[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++) {
                adjMatrix[i][j] = sc.nextLine();
                if(adjMatrix[i][j].equals("i")){
                    srci = i;
                    srcj = j;
                }
                if(adjMatrix[i][j].equals("h")){
                    desti = i;
                    destj = j;
                }
            }
        }

        int[] directionsX = {+1, -1, 0};
        int[] directionsY = {+1, -1, 0};

        //bfs
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int[] visited = new int[n];
        int distance[] = new int[n];
//        queue.add(src);
//        visited[src] = 1;
//
//        while(!queue.isEmpty()){
//            int current = queue.remove();
//            if(!adjMap.containsKey(current)){
//                continue;
//            }
//            for(Integer child: adjMap.get(current)) {
//                if(visited[child]==0 && cursed[child]==0){
//                    visited[child] = 1;
//                    queue.add(child);
//                    distance[child] = distance[current]+1;
//                    if(child==dest){
//                        System.out.println(distance[child]);
//                        System.exit(0);
//                    }
//
//                }
//            }
//        }
        System.out.println(-1);
    }
}
