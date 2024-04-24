package HeapMap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class JoinSticks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long N = scanner.nextLong();
        scanner.nextLine();
        String s =scanner.nextLine();
        String[] sArr = s.split(" ");


        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
                minHeap.offer(Long.valueOf(sArr[i])); // Insert value Longo min heap
            }
        long ans = 0;

        while(minHeap.size()>1)  {
          long sum = 0;
         sum= minHeap.poll()+  minHeap.poll();

         ans+=sum;
         minHeap.offer(sum);
        }

        System.out.print(ans);
        scanner.close();
        }

}
