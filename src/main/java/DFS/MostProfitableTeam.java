package DFS;

import java.util.*;

public class MostProfitableTeam {

    public static void main(String args[]) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int noOfEmployees = sc.nextInt();
        int[] profits = new int[noOfEmployees+1];
        int[] results = new int[noOfEmployees+1];

        int visited[] = new int[noOfEmployees+1];
        for(int i = 2; i<=noOfEmployees; i++){
            int boss = sc.nextInt();
            List<Integer> children = new ArrayList<>();
            if(adjMap.containsKey(boss)){
                children = adjMap.get(boss);
            }
            children.add(i);
            adjMap.put(boss, children);
        }
        for(int i = 1; i<=noOfEmployees; i++){
            profits[i] = sc.nextInt();
        }
        dfs(1, visited,profits, results, adjMap);
        int max = 0;
        for(int i = 1; i<=noOfEmployees; i++){
            System.out.println(results[i]);
            if(max<results[i])
                max = results[i];
        }

        System.out.println(max);

    }

    private static int dfs(int i, int[] visited, int[] profits, int[] results, Map<Integer, List<Integer>> adjMap) {

        visited[i] = 1;
        results[i] = profits[i];
        if(adjMap.containsKey(i)) {
            for (int child : adjMap.get(i)) {
                if (visited[child] == 0) {
                    dfs(child, visited,profits, results, adjMap);
                    results[i]  += results[child];

                }
            }
        }
        return results[i];
    }
}
