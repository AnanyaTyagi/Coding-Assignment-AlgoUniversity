import java.util.HashMap;
import java.util.Map;

public class Singleton {


    public static void main(String args[]){
          int[ ] arr = {1, 2,6,4, 3,0};
          int target = 7;

          HashMap<Integer, Integer> map = new HashMap<>();
          int answer1 = -1;
          int answer2 = -1;
          for(int i = 0;i<arr.length;i++){
              if(!map.containsKey(arr[i])){
                  map.put(arr[i], i);
              }
          }
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                System.out.println("Indexes are: "+i +" and " + map.get(target-arr[i]));
            }
        }


    }
}
