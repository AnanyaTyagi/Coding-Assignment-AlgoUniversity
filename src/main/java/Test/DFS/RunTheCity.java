package Test.DFS;

import java.util.*;

public class RunTheCity {

    public static void main(String args[]) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int result = 0;
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

        //dfs
       int solution = dfs(1, visited, result, adjMap);
       // System.out.println(solution);
        System.out.println(solution>=X? "YES": "NO");

    }

    private static int dfs(int i, int[] visited, int result, Map<Integer, List<Integer>> adjMap) {
        visited[i] = 1;
        if(adjMap.containsKey(i)) {
            for (int child : adjMap.get(i)) {
                if (visited[child] == 0 )
                    result = dfs(child, visited, result, adjMap);
            }
        } else{
            result+=i;
        }
        return result;
    }
}
