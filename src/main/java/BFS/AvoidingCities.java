package BFS;

import java.util.*;

public class AvoidingCities {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int src = sc.nextInt();
        int dest = sc.nextInt();

        int[] cursed = new int[n];
        for(int i = 0; i<n; i++){
            cursed[i] = sc.nextInt();
        }
        Map<Integer, List<Integer>> adjMap = new HashMap<>();


        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            List<Integer> nodesA = new ArrayList<>();
            List<Integer> nodesB = new ArrayList<>();
            if(adjMap.containsKey(a)){
                nodesA =  adjMap.get(a);
                nodesA.add(b);
            } else {
                nodesA.add(b);
            }
            adjMap.put(a, nodesA);

            if(adjMap.containsKey(b)){
                nodesB =  adjMap.get(b);
                nodesB.add(a);
            } else {
                nodesB.add(a);
            }
            adjMap.put(b, nodesB);
        }

        //bfs
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int[] visited = new int[n];
        int distance[] = new int[n];
        queue.add(src);
        visited[src] = 1;

        while(!queue.isEmpty()){
            int current = queue.remove();
            if(!adjMap.containsKey(current)){
                continue;
            }
            for(Integer child: adjMap.get(current)) {
                if(visited[child]==0 && cursed[child]==0){
                    visited[child] = 1;
                    queue.add(child);
                    distance[child] = distance[current]+1;
                    if(child==dest){
                        System.out.println(distance[child]);
                        System.exit(0);
                    }

                }
            }
        }
        System.out.println(-1);
    }
}
//use adjacency list