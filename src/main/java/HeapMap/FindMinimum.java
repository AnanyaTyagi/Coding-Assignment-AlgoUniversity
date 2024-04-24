package HeapMap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FindMinimum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); for maxHeap
        for (int i = 0; i < N; i++) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int value = scanner.nextInt();
                minHeap.offer(value); // Insert value into min heap
            } else if (queryType == 2) {
                if (!minHeap.isEmpty()) {
                    int min = minHeap.poll(); // Retrieve and remove the minimum value
                    System.out.println(min); // Output the minimum value
                }
            }
        }
        scanner.close();
    }
}
