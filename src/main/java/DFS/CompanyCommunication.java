package DFS;

import java.util.*;

public class CompanyCommunication {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] visited = new int[N + 1];

        Map<Integer, List<Integer>> mapOfLanguageToEmployeeNum = new HashMap<>();
        Map<Integer, List<Integer>> empAdj = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String str = sc.nextLine();
            String[] strArray = str.split(" ");
            int size = Integer.valueOf(strArray[0]);
            int index = 1;
            while (size-- > 0) {
                mapOfLanguageToEmployeeNum.putIfAbsent(Integer.valueOf(strArray[index]), new ArrayList<>());
                mapOfLanguageToEmployeeNum.get(Integer.valueOf(strArray[index])).add(i);
                index++;
            }

        }
        for (List<Integer> employees : mapOfLanguageToEmployeeNum.values()) {
            for (int i = 0; i < employees.size(); i++) {
                for (int j = i + 1; j < employees.size(); j++) {
                    int emp1 = employees.get(i);
                    int emp2 = employees.get(j);
                    empAdj.putIfAbsent(emp1, new ArrayList<>());
                    empAdj.putIfAbsent(emp2, new ArrayList<>());
                    empAdj.get(emp1).add(emp2);
                    empAdj.get(emp2).add(emp1);
                }
            }
        }
        dfs(empAdj,visited, 1 );

        boolean flag = true;
        for(int i =1;i<visited.length;i++){
            if(visited[i]==0){
                flag = false;
                break;
            }
        }
        System.out.println(flag?"YES":"NO");
    }

    private static void dfs( Map<Integer, List<Integer>> adjMap,  int[] visited, int i) {

        visited[i] = 1;
        if (adjMap.containsKey(i)) {
            for (int child : adjMap.get(i)) {
                if (visited[child] == 0) {
                    dfs(adjMap, visited, child);

                }
            }
        }
    }
}
