package DFS;


import java.util.*;

public class FarthestNode {
    static int endPoint;
    static int max_distance;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[]  dist = new int[N+1];

        sc.nextLine();
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            String str = sc.nextLine();
            String[] strArr = str.split(" ");
            adjMap.putIfAbsent(Integer.valueOf(strArr[0]), new ArrayList<>());
            adjMap.putIfAbsent(Integer.valueOf(strArr[1]), new ArrayList<>());
            adjMap.get(Integer.valueOf(strArr[0])).add(Integer.valueOf(strArr[1]));
            adjMap.get(Integer.valueOf(strArr[1])).add(Integer.valueOf(strArr[0]));
        }

        findEndPoint(1, 0, adjMap, 0, dist);
        int endPoint1 = endPoint;
        max_distance = 0;
        findEndPoint(endPoint1, 0, adjMap, 0, dist);
        int endPoint2 = endPoint;
        dfs(endPoint1, 0, adjMap, 0, dist);
        dfs(endPoint2, 0, adjMap, 0, dist);
        for(int i = 0; i<dist.length;i++)
            System.out.print(dist[i]+" ");

    }

    private static void dfs(int index, int parent, Map<Integer, List<Integer>> adjMap, int depth, int[] dist) {

        dist[index] = Math.max(dist[index], depth);
        if (adjMap.containsKey(index)) {
            for (int child : adjMap.get(index)) {
                if (child != parent) {
                    dfs(child, index, adjMap, depth + 1, dist);
                }
            }
        }
    }

    private static void findEndPoint(int index, int parent, Map<Integer, List<Integer>> adjMap, int depth, int[] dist) {

        dist[index] = Math.max(dist[index], depth);
        if (max_distance < depth) {
            max_distance = depth;
            endPoint = index;
        }

        if (adjMap.containsKey(index)) {
            for (int child : adjMap.get(index)) {
                if (child != parent) {
                    findEndPoint(child, index, adjMap, depth + 1, dist);
                }
            }
        }
    }
}
