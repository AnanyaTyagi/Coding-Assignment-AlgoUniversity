package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FrequencySort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        Integer N = Integer.parseInt(str);
        String[] st = bufferedReader.readLine().split(" ");
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st[i]);
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int count = map.get(array[i]);
                map.put(array[i], ++count);
            }
        }

        List<Pair> pairList = new ArrayList<Pair>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
           pairList.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(pairList, new customComparator());

        for(int i=0; i<pairList.size(); i++){
            int t = pairList.get(i).y;
            while(t-->0)
                System.out.print(pairList.get(i).x+" ");
        }


    }
    static class customComparator implements Comparator<Pair>{
        public int compare(Pair p, Pair q){
            if(p.y>q.y) return q.y-p.y;
            if(p.y==q.y) return p.x-q.x;
            else return q.y-p.y;
        }

    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
