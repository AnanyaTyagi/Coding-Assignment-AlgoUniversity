package ShortestPathTopoSort;

import java.util.*;

public class ProgrammingLibrary {

    public static void main(String args[]) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
         Stack<Integer> stack = new Stack<Integer>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int visited[] = new int[N+1];

        for(int i = 1; i<=M; i++){

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
        for(int i = 0;i<N;i++) {
            if (visited[i]==0) {
                dfs(i, visited, adjMap, stack);
            }
        }

        while (!stack.isEmpty()) {
            int element = stack.pop(); // Remove and print element
            System.out.print(element+" ");
        }    }

    private static void dfs(int i, int[] visited, Map<Integer, List<Integer>> adjMap, Stack<Integer> stack) {
        visited[i] = 1;
        if(adjMap.containsKey(i)) {
            for (int child : adjMap.get(i)) {
                if (visited[child] == 0 )
                    dfs(child, visited, adjMap, stack);
            }
        }
        stack.push(i);

    }
}
