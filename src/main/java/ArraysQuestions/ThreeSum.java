package ArraysQuestions;

import java.util.*;

public class ThreeSum  {
        public List<List<Integer>> threeSum(int[] array) {
            Arrays.sort(array);
            List<List<Integer>> triplets = new ArrayList<>();
            Set<List<Integer>> set = new HashSet<>();

            for (int i = 0; i < array.length - 2; i++) {
                if (i == 0 || (i > 0 && array[i] != array[i - 1])) {
                    int left = i + 1;
                    int right = array.length - 1;

                    while (left < right) {
                        int currentSum = array[i] + array[left] + array[right];

                        if (currentSum == 0) {
                            List<Integer> triplet = Arrays.asList(array[i], array[left], array[right]);
                            // Check if the triplet is unique
                            if (!set.contains(triplet)) {
                                triplets.add(triplet);
                                set.add(triplet); // Add the triplet to the set
                            }

                            // Move pointers
                            left++;
                            right--;
                        } else if (currentSum < 0) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }

            return triplets;
        }

}
