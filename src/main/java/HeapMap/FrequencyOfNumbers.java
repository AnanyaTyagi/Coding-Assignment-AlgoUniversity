package HeapMap;

import java.util.*;

public class FrequencyOfNumbers {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            scanner.nextLine();
            String s =scanner.nextLine();
            String[] sArr = s.split(" ");
            int arr[] = new int[N];
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<ItemValue> minHeap = new PriorityQueue<>(new Comparator<ItemValue>() {
                @Override
                public int compare(ItemValue a, ItemValue b) {
                    int freqCompare = Integer.compare(b.frequency, a.frequency);
                    if (freqCompare != 0) {
                        return freqCompare; // If frequencies are different, return the comparison result
                    } else {
                        // If frequencies are the same, compare based on the number in ascending order
                        return Integer.compare(a.number, b.number);
                    }

                }
            });
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.valueOf(sArr[i]); // Insert value Longo min heap
                if(map.containsKey(arr[i])){
                   map.put(arr[i], map.get(arr[i])+1);

                }else{
                    map.put(arr[i], 1);
                }

            }

            for(Map.Entry e:map.entrySet()){
             minHeap.offer(new ItemValue((Integer) e.getKey(), (Integer) e.getValue()));
            }

            while(K-->0){
              ItemValue itemValue =minHeap.poll();
              System.out.print(itemValue.number+" ");

            }
            scanner.close();
        }

    static class ItemValue {

        int number, frequency;

        // Item value function
        public ItemValue(int val, int wt)
        {
            this.number = val;
            this.frequency = wt;
        }
    }


}

