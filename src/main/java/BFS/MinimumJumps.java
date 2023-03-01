package BFS;

import java.util.*;

public class MinimumJumps {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
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
        int src = sc.nextInt();
        int dest = sc.nextInt();

        //bfs
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int[] visited = new int[n+1];
        int distance[] = new int[n+1];
        queue.add(src);
        visited[src] = 1;

        while(!queue.isEmpty()){
            int current = queue.remove();

            for(Integer child: adjMap.get(current)) {
                 if(visited[child]==0){
                     visited[child] = 1;
                     queue.add(child);
                     distance[child] = distance[current]+1;
                 }
                 if(child==dest){
                     System.out.println(distance[child]);
                    System.exit(0);
                 }
            }
        }
        System.out.println(0);
    }
}
