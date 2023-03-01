package DFS;


import java.util.*;

public class CompanyHierarchy {


    public static void main(String args[]) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int noOfEmployees = sc.nextInt();
        int[] result = new int[noOfEmployees+1];

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

        //dfs
        dfs(1, visited, result, adjMap);


        for(int i = 1; i<=noOfEmployees; i++){
            System.out.print(result[i]+ " ");
         }
    }

    private static int dfs(int i, int[] visited, int[] result, Map<Integer, List<Integer>> adjMap) {
        visited[i] = 1;
        if(adjMap.containsKey(i)) {
            for (int child : adjMap.get(i)) {
                if (visited[child] == 0)
                    result[i] = result[i] + dfs(child, visited, result, adjMap) + 1;
            }
        }
        return result[i];
    }
}
