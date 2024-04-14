//package DFS;
//
//import java.util.*;
//
//public class CompanyCommunication {
//
//    public static void main(String args[]) {
//        Map<Integer, List<Integer>> adjMap = new HashMap<>();
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//         for(int i = 1; i<N;i++){
//             List<Integer> list = new ArrayList<>();
//             String str = sc.nextLine();
//            String[] strArray= str.split(" ");
//            int n = strArray.length;
//            int j =0;
//            while(n>0){
//                list.add(strArray[j])
//                n--;
//            }
//             adjMap.put(i, )
//         }
//
//        for()
//        dfs(1, visited,profits, results, adjMap);
//        int max = Integer.MIN_VALUE;
//        for(int i = 1; i<=noOfEmployees; i++){
//            System.out.println(results[i]);
//            if(max<results[i])
//                max = results[i];
//        }
//
//        System.out.println(max);
//
//    }
//
//    private static int dfs(int i, int[] visited, int[] profits, int[] results, Map<Integer, List<Integer>> adjMap) {
//
//        visited[i] = 1;
//        results[i] = profits[i];
//        if(adjMap.containsKey(i)) {
//            for (int child : adjMap.get(i)) {
//                if (visited[child] == 0) {
//                    dfs(child, visited,profits, results, adjMap);
//                    results[i]  += results[child];
//
//                }
//            }
//        }
//        return results[i];
//    }
//}
