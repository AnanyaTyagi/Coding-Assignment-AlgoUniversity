package ArraysQuestions;

import java.util.*;

public class KnightConnection {
    public int knightConnection(int[] knightA, int[] knightB) {
        // Write your code here.
        int[][] possibleMoves = new int[][] {
                {-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}
        };
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        // adding strating position of knightA in queue with  minimumdistance  initialised as third value
        queue.add(Arrays.asList(knightA[0], knightA[1], 0));
        Set<String> visited  = new HashSet<String>();
        visited.add(knightA.toString());

        while(true){
            List<Integer> currentPosition = queue.remove();
            if(currentPosition.get(0)==knightB[0] && currentPosition.get(1)==knightB[1]){
                return (int) Math.ceil((double)currentPosition.get(2)/2);

            }
            for(int[] possibleMove : possibleMoves){
                ArrayList<Integer> position = new ArrayList<Integer>();
                position.add(currentPosition.get(0) + possibleMove[0]);
                position.add(currentPosition.get(1) + possibleMove[1]);
                String positionString = position.toString();

                if(!visited.contains(positionString)) {
                    //add third element represting numberof moves in position array
                    position.add(currentPosition.get(2)+1);
                    queue.add(position);
                    visited.add(positionString);
                }

            }
        }
    }
}
