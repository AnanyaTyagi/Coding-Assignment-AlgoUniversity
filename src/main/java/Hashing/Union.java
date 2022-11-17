package Hashing;

import java.util.*;

public class Union {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer N = s.nextInt();
        Integer M = s.nextInt();

        int[] array1 = new int[N];
        int[] array2 = new int[M];
        Set<Integer> set = new HashSet<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < N; i++) {
            array1[i]= s.nextInt();
            map.put(array1[i], i);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            set.add(entry.getKey());
        }

        for (int j = 0; j < M; j++) {
            array2[j] = s.nextInt();
            if(!map.containsKey(array2[j])){
                set.add(array2[j]);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Iterator iterator = list.listIterator();
        while(iterator.hasNext())
            System.out.print(iterator.next() + " ");

    }
}
