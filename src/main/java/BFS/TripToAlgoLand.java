package BFS;

import java.util.*;

public class TripToAlgoLand {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        Map<String, List<Pair>> adjMap = new HashMap<>();
        Map<String, Integer> visited = new HashMap<>();
        Map<String, Pair> parent = new HashMap<>();//from here using this path
        Queue<String> queue = new ArrayDeque<String>();

        for (int i = 0; i < m; i++) {
            String stringOfCity = sc.nextLine();
            String[] strings = stringOfCity.split(" ");
            String city = strings[0];
            String destination = strings[1];
            String path = strings[2];
            Pair pair = new Pair(destination, path);
            List<Pair> pairList = new ArrayList<Pair>();

            if (adjMap.containsKey(city)) {
                pairList = adjMap.get(city);
            }
            pairList.add(pair);
            adjMap.put(city, pairList);
        }

        String stringOfCity = sc.nextLine();
        String[] strings = stringOfCity.split(" ");
        String srcCity = strings[0];
        String destCity = strings[1];

        queue.add(srcCity);
        while (!queue.isEmpty()) {
            String current = queue.remove();
            visited.put(current, 1);
            if(Objects.isNull(adjMap.get(current)))
                continue;
            for (Pair child : adjMap.get(current)) {

                if (visited.get(child.connectingCity) == null) {
                    queue.add(child.connectingCity);
                    visited.put(child.connectingCity, 1);
                    parent.put(child.connectingCity, new Pair(current, child.roadName));
                }
            }
        }
        parent.put(srcCity, new Pair("-1", "-1"));
        List<String> result = new ArrayList<>();

        if (!Objects.isNull(visited.get(destCity))) {
            while (!destCity.equals("-1")) {
                result.add(parent.get(destCity).roadName);
                destCity = parent.get(destCity).connectingCity;
            }

            Collections.reverse(result);
            System.out.println(result.size()-1);
            for (String city : result) {
                if(city.equals("-1"))
                    continue;
                System.out.println(city);
            }
            return;
        }
        System.out.println("Impossible");

    }

    static class Pair {
        String connectingCity;
        String roadName;

        Pair(String cC, String rN) {
            connectingCity = cC;
            roadName = rN;
        }
    }
}
