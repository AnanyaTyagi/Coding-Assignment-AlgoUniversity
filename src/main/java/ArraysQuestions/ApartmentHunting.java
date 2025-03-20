package ArraysQuestions;

import java.util.List;
import java.util.Map;


//https://medium.com/@pandeyroshan556/apartment-hunting-problem-85c6acee8741


//Problem Statement — You’re looking to move into a new apartment, and you’re given a list of blocks where each block contains some services that it offers. In order to pick your apartment, you want to optimize its location in such a way that the maximum distance to any services that you care for is minimized.
//
//        Example —
//
//        blocks = [ { “gym” : true, “school” : true, “store” : false } ,{ “gym” : true, “school” : true, “store” : false } ,{ “gym” : true, “school” : true, “store” : false } ,{ “gym” : true, “school” : true, “store” : false } ,{ “gym” : true, “school” : true, “store” : false } ]
//
//        requirements = [ “gym”, “school”, “store” ]
//

public class ApartmentHunting {
        public static int apartmentHunting(
                List<Map<String, Boolean>> blocks, String[] reqs
        ) {
            // For each requirement, calculate the minimum distances to each block
            int[][] minDistancesFromBlocks = new int[reqs.length][];
            for (int i = 0; i < reqs.length; i++) {
                minDistancesFromBlocks[i] = getMinDistances(blocks, reqs[i]);
            }
            // Calculate the maximum distances at each block to satisfy all requirements
            int[] maxDistancesAtBlocks = getMaxDistancesAtBlocks(blocks, minDistancesFromBlocks);
            // Find the index of the block with the minimum maximum distance
            return getIdxAtMinValue(maxDistancesAtBlocks);
        }

        public static int[] getMinDistances(List<Map<String, Boolean>> blocks, String req) {
            int[] minDistances = new int[blocks.size()];
            int closestReqIdx = -1; // Initialize to -1 to signify not found

            for (int i = 0; i < blocks.size(); i++) {
                // Check if the requirement exists in the current block
                if (blocks.get(i).getOrDefault(req, false)) {
                    closestReqIdx = i; // Update to the current index if found
                }
                // Calculate distances
                minDistances[i] = closestReqIdx == -1 ? Integer.MAX_VALUE : distanceBetween(i, closestReqIdx);
            }
            // Now, we need to go backwards to also accommodate for cases where the closest was found previously
            closestReqIdx = -1;
            for (int i = blocks.size() - 1; i >= 0; i--) {
                if (blocks.get(i).getOrDefault(req, false)) {
                    closestReqIdx = i;
                }
                if (closestReqIdx != -1) {
                    minDistances[i] = Math.min(minDistances[i], distanceBetween(i, closestReqIdx));
                }
            }
            return minDistances;
        }

        public static int[] getMaxDistancesAtBlocks(List<Map<String, Boolean>> blocks, int[][] minDistancesFromBlocks) {
            int[] maxDistancesAtBlocks = new int[blocks.size()];
            // For each block, get the maximum distance required among all amenities
            for (int i = 0; i < blocks.size(); i++) {
                int[] minDistancesAtBlock = new int[minDistancesFromBlocks.length];
                for (int j = 0; j < minDistancesFromBlocks.length; j++) {
                    minDistancesAtBlock[j] = minDistancesFromBlocks[j][i];
                }
                maxDistancesAtBlocks[i] = arrayMax(minDistancesAtBlock);
            }
            return maxDistancesAtBlocks;
        }

        public static int getIdxAtMinValue(int[] array) {
            int idxAtMinValue = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                int currentValue = array[i];
                if (currentValue < minValue) {
                    minValue = currentValue;
                    idxAtMinValue = i;
                }
            }
            return idxAtMinValue;
        }

        public static int distanceBetween(int a, int b) {
            return Math.abs(a - b);
        }

        public static int arrayMax(int array[]) {
            int max = array[0];
            for (int a : array) {
                if (a > max) {
                    max = a;
                }
            }
            return max;
        }
    }

