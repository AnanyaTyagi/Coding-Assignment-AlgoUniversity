package ArraysQuestions;

import java.util.ArrayList;
import java.util.Comparator;

public class SweetSavouryDish {

    public int[] sweetAndSavory(int[] dishes, int target) {
        ArrayList<Integer> sweetDishes = new ArrayList<Integer>();
        ArrayList<Integer> savoryDishes = new ArrayList<Integer>();

        for (int dish : dishes) {
            if (dish < 0) {
                sweetDishes.add(dish);

            } else {
                savoryDishes.add(dish);
            }
        }
        sweetDishes.sort(Comparator.comparingInt(Math::abs));
        savoryDishes.sort(Comparator.naturalOrder());

        int[] bestPair = new int[2];
        int bestDifference = Integer.MAX_VALUE;
        int sweetIndex = 0, savoryIndex = 0;

        while (sweetIndex < sweetDishes.size() && savoryIndex < savoryDishes.size()) {

            int currentSum = sweetDishes.get(sweetIndex) + savoryDishes.get(savoryIndex);

            if (currentSum <= target) {
                int currentDifference = target - currentSum;
                if (currentDifference < bestDifference) {
                    bestDifference = currentDifference;
                    bestPair[0] = sweetDishes.get(sweetIndex);
                    bestPair[1] = savoryDishes.get(savoryIndex);

                }
                savoryIndex++;
            } else {
                sweetIndex++;
            }
        }
        return bestPair;

    }
}
