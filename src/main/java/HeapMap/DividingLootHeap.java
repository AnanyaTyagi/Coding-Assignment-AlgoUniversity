package HeapMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

//TODO
public class DividingLootHeap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] sArr = s.split(" ");
        int[] arr = new int[N];
        PriorityQueue<PersonCost> minHeap = new PriorityQueue<>(new Comparator<PersonCost>() {
            @Override
            public int compare(PersonCost o1, PersonCost o2) {
                return o1.cost-o2.cost;
            }
        });
        int maxCost = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(sArr[i]); // Insert value Longo min heap
            maxCost = Math.max(arr[i], maxCost);
        }

        for(int i = 1; i<=M;i++)
            minHeap.offer(new PersonCost(i, 0));

        for (int i = 0; i<N;i++){
             PersonCost personCost = minHeap.poll();
             personCost.cost = personCost.cost+arr[i];
             minHeap.offer(personCost);
            System.out.print(personCost.personNumber+" ");

        }
    }

    public static class PersonCost{
        int personNumber;
        int cost;

        public PersonCost(int val, int wt)
        {
            this.personNumber = val;
            this.cost = wt;
        }
    }

}
