package DFS;

import java.util.*;

public class RedAlert {
    public static void main(String args[]) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] redNodes = new int[N+1];
        int result = 0;

        int visited[] = new int[N+1];
        for(int i = 1; i<=N; i++){
             redNodes[i] = sc.nextInt();
        }
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
            System.out.println(dfs(1, visited, adjMap, redNodes, 0, C));

    }

    private static int dfs(int i, int[] visited,Map<Integer, List<Integer>> adjMap, int[] redNodes, int consecutive_fire, int C) {

        visited[i] = 1;
        consecutive_fire+=redNodes[i];

        //if, current is no fire, then reset
        if( redNodes[i]==0 )
            consecutive_fire = 0;
            // if, fire increases, then return ( i.e. NO PATH)
        else if( consecutive_fire > 2*C )
            return 0;

        boolean is_leaf = true;
        int  leaf_by_child = 0;

        if(!Objects.isNull(adjMap.get(i))) {

            for (int child : adjMap.get(i)) {
                if (visited[child] == 0) {
                    is_leaf = false;
                    leaf_by_child += dfs(child, visited, adjMap, redNodes, consecutive_fire, C);
                }

            }

        }

        // if, it's leaf we return 1
        if( is_leaf )
            return 1;
        // else, we sum the leaf child
        return leaf_by_child;
    }
}
