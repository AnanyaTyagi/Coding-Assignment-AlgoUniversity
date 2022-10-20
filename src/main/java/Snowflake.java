import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Snowflake {

    public static void main(String[] args) {

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

        HashMap<Integer, List<Integer>> mapOfDegreedNodes = new HashMap<>();

        s.close();

        Integer[][] adjacencyMatrix = new Integer[noOfNodes + 1][noOfNodes + 1];


//        for (int i = 0; i <= noOfNodes; i++) {
//            visited[i] = 0;
//            for (int j = 0; j <= noOfNodes; j++) {
//                adjacencyMatrix[i][j] = 0;
//            }
//        }
//        for (int i = 0; i < edgesCount; i++) {
//
////            visited[arrOfedges[i][0]] = 1;
////            visited[arrOfedges[i][1]] = 1;
//
//            if (adjacencyMatrix[arrOfedges[i][0]][arrOfedges[i][1]] == 0) {
//                adjacencyMatrix[arrOfedges[i][0]][arrOfedges[i][1]] = 1;
//                adjacencyMatrix[arrOfedges[i][1]][arrOfedges[i][0]] = 1;
//
//
//            } else if (adjacencyMatrix[arrOfedges[i][0]][arrOfedges[i][1]] > 0) {
//                adjacencyMatrix[arrOfedges[i][0]][arrOfedges[i][1]] += 1;
//                adjacencyMatrix[arrOfedges[i][1]][arrOfedges[i][0]] += 1;
//
//            }
//        }
//
//        for (int i = 1; i <= noOfNodes; i++) {
//
//            int count = 0;
//            for (int j = 1; j <= noOfNodes; j++) {
//
//                if(adjacencyMatrix[i][j] >=1) {
//                    count ++;
//                }
//
//            }
//            mapOfNumberDegree.put(i, count);
//
//        }
//
//
//        System.out.println(mapOfNumberDegree);
//        System.out.println(mapOfDegrees);
//
//        Integer countOfSnowflakes = 0;
//        int unVisitedCount = 0;
//
//        for(int j=1; j<visited.length;j++) {
//            //to check unvisited node count
//             if(visited[j]==0)
//                 unVisitedCount++;
//        }
//
//        if(unVisitedCount == 1)
//            countOfSnowflakes ++;
//
//        for(Map.Entry<Integer, Integer> entry : mapOfDegrees.entrySet()) {
//
//        }
//
//        System.out.println(countOfSnowflakes);


//        //////INPUT TAKING OVER HERE////////////


        for (int i = 0; i <= noOfNodes; i++) {
            for (int j = 0; j <= noOfNodes; j++) {
                System.out.print(adjacencyMatrix[i][j]);
            }
            System.out.println();

        }
        HashMap<Integer, Integer> mapOfDegrees = new HashMap<Integer, Integer>();

        //creating array for visited nodes and a 'mapOfDegrees' for node and its degree and a 'mapOfDegreedNodes' for node and an array containing its connected nodes
        //created for 4 cases if 1st node and 2nd node don't exist, first and second node both exist and two other cases if only one of them already exists in above maps.
        for(int i =0; i<arrOfedges.length; i++) {



           if ((visited[arrOfedges[i][0]] != 1 && visited[arrOfedges[i][1]] == 1) || (visited[arrOfedges[i][0]] == 1 && visited[arrOfedges[i][1]] != 1) || (visited[arrOfedges[i][0]] == 0 && visited[arrOfedges[i][1]] == 0) ||
                   (visited[arrOfedges[i][0]] == 1 && visited[arrOfedges[i][1]] == 1 && !mapOfDegreedNodes.get(arrOfedges[i][0]).contains(arrOfedges[i][1]))) {

                if (!mapOfDegrees.containsKey(arrOfedges[i][0]) && !mapOfDegrees.containsKey(arrOfedges[i][1])) {

                    mapOfDegrees.put(arrOfedges[i][0], 1);
                    mapOfDegrees.put(arrOfedges[i][1], 1);

                    List<Integer> list1 = new ArrayList<>();
                    List<Integer> list2 = new ArrayList<>();

                    list1.add(arrOfedges[i][1]);
                    list2.add(arrOfedges[i][0]);

                    mapOfDegreedNodes.put(arrOfedges[i][0], list1);
                    mapOfDegreedNodes.put(arrOfedges[i][1], list2);

                } else if (!mapOfDegrees.containsKey(arrOfedges[i][0]) && mapOfDegrees.containsKey(arrOfedges[i][1])) {

                    List<Integer> list1 = new ArrayList<>();
                    List<Integer> list2 = mapOfDegreedNodes.get(arrOfedges[i][1]);

                    list1.add(arrOfedges[i][1]);
                    list2.add(arrOfedges[i][0]);

                    mapOfDegreedNodes.put(arrOfedges[i][0], list1);
                    mapOfDegreedNodes.put(arrOfedges[i][1], list2);

                    Integer degree = mapOfDegrees.get(arrOfedges[i][1]);
                    mapOfDegrees.put(arrOfedges[i][1], ++degree);
                    mapOfDegrees.put(arrOfedges[i][0], 1);
                } else if (!mapOfDegrees.containsKey(arrOfedges[i][1]) && mapOfDegrees.containsKey(arrOfedges[i][0])) {

                    List<Integer> list1 = mapOfDegreedNodes.get(arrOfedges[i][0]);
                    List<Integer> list2 = new ArrayList<>();

                    list1.add(arrOfedges[i][1]);
                    list2.add(arrOfedges[i][0]);

                    mapOfDegreedNodes.put(arrOfedges[i][0], list1);
                    mapOfDegreedNodes.put(arrOfedges[i][1], list2);


                    Integer degree = mapOfDegrees.get(arrOfedges[i][0]);
                    mapOfDegrees.put(arrOfedges[i][0], ++degree);
                    mapOfDegrees.put(arrOfedges[i][1], 1);

                } else {

                    List<Integer> list1 = mapOfDegreedNodes.get(arrOfedges[i][0]);
                    List<Integer> list2 = mapOfDegreedNodes.get(arrOfedges[i][1]);

                    list1.add(arrOfedges[i][1]);
                    list2.add(arrOfedges[i][0]);

                    mapOfDegreedNodes.put(arrOfedges[i][0], list1);
                    mapOfDegreedNodes.put(arrOfedges[i][1], list2);

                    Integer degree = mapOfDegrees.get(arrOfedges[i][1]);
                    mapOfDegrees.put(arrOfedges[i][1], ++degree);
                    Integer degree2 = mapOfDegrees.get(arrOfedges[i][0]);
                    mapOfDegrees.put(arrOfedges[i][0], ++degree2);

                }
            }

            visited[arrOfedges[i][0]] = 1;
            visited[arrOfedges[i][1]] = 1;

        }

        HashSet<Integer> setOfUniqueDegrees =new HashSet<>();
        SortedSet<Integer> alreadyFoundDegrees = new TreeSet<>();
        HashMap<Integer, Integer> mapOfResult = new HashMap<>();

        //setOfUniqueDegrees for creating a set of unique snowflake nodes,
        for (Map.Entry<Integer,Integer> entry : mapOfDegrees.entrySet()) {

            if(setOfUniqueDegrees.contains(entry.getValue()) && entry.getValue() > 1){

                //i removed nodes with similar degree here
                alreadyFoundDegrees.add(entry.getValue());
            }

            if(entry.getValue() > 1 && !setOfUniqueDegrees.contains(entry.getValue())) {
               setOfUniqueDegrees.add(entry.getValue());

               //in this map i only put those nodes who are snowflakes and their degree
               mapOfResult.put(entry.getKey(), entry.getValue());
            }


        }

        for(Map.Entry<Integer,Integer> entry : mapOfResult.entrySet()) {
          List<Integer> list= mapOfDegreedNodes.get(entry.getKey());
          for (Integer i : list) {
              if(mapOfResult.containsKey(i)){
                  //if a node in result map has some nodes whose degree is greater than one then they will be removed here, the degree of those nodes i mean
                  setOfUniqueDegrees.remove(entry.getValue());
                  break;
              }
          }
        }

        Integer unVisitedCount = 0;
        for(int j=1; j<visited.length;j++) {
            //to check unvisited node count
             if(visited[j]==0)
                 unVisitedCount++;
        }

        //add one more node to result if uninvited node is only 1
        if(unVisitedCount ==1)
            setOfUniqueDegrees.add(0);
        System.out.println(setOfUniqueDegrees.size() - alreadyFoundDegrees.size());
    }
}

