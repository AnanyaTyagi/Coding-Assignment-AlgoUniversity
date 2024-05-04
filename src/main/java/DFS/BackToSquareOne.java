package DFS;

import java.util.*;

public class BackToSquareOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] visited = new int[N];
        sc.nextLine();
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            String str = sc.nextLine();
            String[] strArr = str.split(" ");
            adjMap.putIfAbsent(Integer.valueOf(strArr[0]), new ArrayList<>());
            adjMap.putIfAbsent(Integer.valueOf(strArr[1]), new ArrayList<>());
            adjMap.get(Integer.valueOf(strArr[0])).add(Integer.valueOf(strArr[1]));
        }

        for(int i = 0; i<N;i++){
            if(visited[i]==0){
               if(dfs(0, 0, adjMap, visited)==1){
                   System.out.println("NO");
                    System.exit(0);
               }
            }
        }
        System.out.println("YES");

    }

    private static int dfs(int index, int parent, Map<Integer, List<Integer>> adjMap, int[] visited) {

        visited[index] = 1;
        if (adjMap.containsKey(index)) {
            for (int child : adjMap.get(index)) {
                if (visited[child] == 0) {
                    if (dfs(child, index, adjMap, visited) == 1) {
                        return 1;
                    }
                } else if((child != parent) && visited[index] == 1) {
                    return 1;
                }
            }
        }
        visited[index] = 2;
        return 0;
    }
}
