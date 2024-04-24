package DP.Knapsack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {

    //in fractional knapsack greedy works
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //it was never about minimising the cost but maximising the production
        int n = sc.nextInt();
        int w = sc.nextInt();
        ItemValue[] arr = new ItemValue[n];
        double[] fractional = new double[n];
        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
           int weight = sc.nextInt();
            arr[i] = new ItemValue(price, weight); // Instantiate the ItemValue object and assign it to arr[i]


        }


    System.out.println(getMaxValue(arr, w));
    }

    // Function to get maximum value
    private static double getMaxValue(ItemValue[] arr,
                                      int capacity)
    {
        // Sorting items by profit/weight ratio;
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue item1,
                               ItemValue item2)
            {
                double cpr1
                        = (double) item1.profit
                        / (double) item1.weight;
                double cpr2
                        = (double) item2.profit
                        / (double) item2.weight;

                if (cpr1 < cpr2)
                    return 1;
                else
                    return -1;
            }
        });

        double totalValue = 0d;

        for (ItemValue i : arr) {

            int curWt = (int)i.weight;
            int curVal = (int)i.profit;

            if (capacity - curWt >= 0) {

                // This weight can be picked whole
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {

                // Item cant be picked whole
                double fraction
                        = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                capacity
                        = (int)(capacity - (curWt * fraction));
                break;
            }
        }

        return totalValue;
    }

    // Item value class
    static class ItemValue {

        int profit, weight;

        // Item value function
        public ItemValue(int val, int wt)
        {
            this.weight = wt;
            this.profit = val;
        }
    }


}
