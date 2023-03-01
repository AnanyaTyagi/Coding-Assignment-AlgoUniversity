package Test.DFS;

import java.util.*;

public class DiameterOfATree {

   static int maxCount ;
  static  int x ;

    public static void main(String args[]) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Map<Integer, List<Integer>> adjMap2 = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int visited[] = new int[N+1];

        for(int i = 1; i<=N-1; i++){

            int a = sc.nextInt();
            int b = sc.nextInt();
            List<Integer> nodesA = new ArrayList<>();
            if(adjMap.containsKey(a)) {
                nodesA = adjMap.get(a);
            }
            nodesA.add(b);
            adjMap.put(a, nodesA);

        }
    int count = 0;
        dfs(1, visited, adjMap, count);
        System.out.println(x);
     for(int i = 1; i<= N; i++){
         visited[i]=0;
     }
     count = 0;
     dfs(x, visited, adjMap, count);
     System.out.println(count);

    }

    private static void dfs(int i, int[] visited,Map<Integer, List<Integer>> adjMap, int count) {
       // System.out.println("11111111111111111111");
        visited[i] = 1;
        count++;
        if(adjMap.containsKey(i)) {
            for (int child : adjMap.get(i)) {
                if (visited[child] == 0 ){
                    if(count>=maxCount){
                        maxCount= count;
                        x = child;
                    }
                }
                dfs(child, visited, adjMap, count);
            }
        }
    }
}
