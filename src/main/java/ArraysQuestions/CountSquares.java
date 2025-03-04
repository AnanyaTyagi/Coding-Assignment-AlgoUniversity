package ArraysQuestions;

import java.util.HashSet;

public class CountSquares {
//
//    Hi, I stumbled across a simple question:
//
//    Given 4≤𝑁≤1000
//    points on a cartesian plane, count the number of squares where the corner of each squares lie on the points.
//
//    The first obvious method would be to put all the points in a map, and perform an 𝑂(𝑁3)
//    solution to find the last corner point and see if it exists.
//
//    The next method would be to find opposite corner points in 𝑂(𝑁2)
//    time and check if the rest of the two points exist.

        public int countSquares(int[][] points) {
            // Write your code here.
            HashSet<String> pointSet = new HashSet<String>();
            for(int[] point:points){
                pointSet.add(pointToString(point));
            }

            int count = 0;
            for(int[] pointA : points){
                for(int[] pointB : points){
                    if(pointA==pointB){
                        continue;
                    }

                    double[] midpoint = new double[]{
                            (pointA[0] + pointB[0])/2.0 , (pointA[1] + pointB[1])/2.0};
                    double xDistanceFromMid = pointA[0] - midpoint[0];
                    double yDistanceFromMid = pointA[1] - midpoint[1];


                    double[] pointC = new double[]{
                            midpoint[0]+ yDistanceFromMid , midpoint[1] - xDistanceFromMid};
                    double[] pointD = new double[]{
                            midpoint[0] - yDistanceFromMid , midpoint[1] + xDistanceFromMid};

                    if(pointSet.contains(dbPointToString(pointC)) && pointSet.contains(dbPointToString(pointD))){
                        count++;
                    }
                }
            }
            return count/4;

        }
        private String pointToString(int[] point){
            return point[0] + "," + point[1];
        }

        private String dbPointToString(double[] point){
            if(point[0] % 1 ==0 &&  point[1] % 1==0){
                return (int) point[0] + "," + (int)point[1];
            }
            return point[0] + "," + point[1];
        }


}
