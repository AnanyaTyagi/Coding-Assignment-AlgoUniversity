package WarmUp;

import java.util.*;

public class SnowFlake2 {

    public static void main(String[] args) {

        //single nodes
        //two similar degrees that is greater than one
        //two nodes with different degrees but connected in same snowflake

        Scanner s = new Scanner(System.in);
        String stringOfPositions = s.nextLine();
        String[] arrayOfPositions = stringOfPositions.split(" ");

        Integer noOfNodes = Integer.valueOf(arrayOfPositions[0]);
        Integer noOfEdges = Integer.valueOf(arrayOfPositions[1]);
        Integer edgesCount = noOfEdges;

        Integer[][] arrOfedges = new Integer[noOfEdges][2];
        Integer index = 0;

        Integer[] visited = new Integer[noOfNodes + 1];

        if (noOfNodes == 1) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
        while (noOfEdges != 0) {

            String edge = s.nextLine();
            String[] distSpeedArr = edge.split(" ");
            arrOfedges[index][0] = Integer.valueOf(distSpeedArr[0]);
            arrOfedges[index][1] = Integer.valueOf(distSpeedArr[1]);
            index++;
            noOfEdges--;

        }


        s.close();

        //////////INPUT TAKEN NOW CODE STARTS BELOW//////////////////
        Map<Integer, List<Integer>> mapOfNodesWithDegreedNodes = new HashMap<>();

        for (int i = 0; i < arrOfedges.length; i++) {

            if (!mapOfNodesWithDegreedNodes.containsKey(arrOfedges[i][0]) && !mapOfNodesWithDegreedNodes.containsKey(arrOfedges[i][1])) {


                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();

                list1.add(arrOfedges[i][1]);
                list2.add(arrOfedges[i][0]);

                mapOfNodesWithDegreedNodes.put(arrOfedges[i][0], list1);
                mapOfNodesWithDegreedNodes.put(arrOfedges[i][1], list2);

            } else if (!mapOfNodesWithDegreedNodes.containsKey(arrOfedges[i][0]) && mapOfNodesWithDegreedNodes.containsKey(arrOfedges[i][1])) {

                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = mapOfNodesWithDegreedNodes.get(arrOfedges[i][1]);

                list1.add(arrOfedges[i][1]);
                list2.add(arrOfedges[i][0]);

                mapOfNodesWithDegreedNodes.put(arrOfedges[i][0], list1);
                mapOfNodesWithDegreedNodes.put(arrOfedges[i][1], list2);

            } else if (!mapOfNodesWithDegreedNodes.containsKey(arrOfedges[i][1]) && mapOfNodesWithDegreedNodes.containsKey(arrOfedges[i][0])) {

                List<Integer> list1 = mapOfNodesWithDegreedNodes.get(arrOfedges[i][0]);
                List<Integer> list2 = new ArrayList<>();

                list1.add(arrOfedges[i][1]);
                list2.add(arrOfedges[i][0]);

                mapOfNodesWithDegreedNodes.put(arrOfedges[i][0], list1);
                mapOfNodesWithDegreedNodes.put(arrOfedges[i][1], list2);


            } else {

                List<Integer> list1 = mapOfNodesWithDegreedNodes.get(arrOfedges[i][0]);
                List<Integer> list2 = mapOfNodesWithDegreedNodes.get(arrOfedges[i][1]);

                list1.add(arrOfedges[i][1]);
                list2.add(arrOfedges[i][0]);

                mapOfNodesWithDegreedNodes.put(arrOfedges[i][0], list1);
                mapOfNodesWithDegreedNodes.put(arrOfedges[i][1], list2);


            }
          visited[arrOfedges[i][0]]=1;
            visited[arrOfedges[i][1]]=1;


        }

        Map<Integer, Integer> mapOfDegrees = new HashMap<>();
        Map<Integer, Integer> sizeMap = new HashMap<>();

        //for duplicacy
        for (Map.Entry<Integer, List<Integer>> entry : mapOfNodesWithDegreedNodes.entrySet()) {
            if (entry.getValue().size() != 1) {
                mapOfDegrees.put(entry.getKey(), entry.getValue().size());
                for (Integer node : entry.getValue()) {
                    if (mapOfNodesWithDegreedNodes.get(node).size() != 1) {
                        mapOfDegrees.put(entry.getKey(), -1);
                        break;
                    }
                }
            }
        }


        for (Map.Entry<Integer, Integer> entry : mapOfDegrees.entrySet()) {

            if (sizeMap.get(entry.getValue()) != null) {
                int size = sizeMap.get(entry.getValue());
                sizeMap.put(entry.getValue(), ++size);
                continue;
            }

            if (Objects.isNull(sizeMap.get(entry.getValue())) && entry.getValue() != -1) {
                sizeMap.put(entry.getValue(), 1);
            }

        }

        int sum =0;
        int unVisitedCount = 0;

        for(int j=1; j<visited.length;j++) {
            //to check unvisited node count
             if(visited[j]==0)
                 unVisitedCount++;
        }

        if(unVisitedCount == 1)
            sum ++;

        for (Map.Entry<Integer, Integer> entry : sizeMap.entrySet()) {
              if(entry.getValue() == 1)
              sum = sum +1;
        }
        System.out.println(sum);
    }
}