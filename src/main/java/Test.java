import java.util.*;

public class Test {

    public static void main(String args[]){
//        int[] arr = {1, 3, 2, 8, 5};
//        boolean check= checkForDuplicacy(arr);
//        System.out.println(check==true?"true":"false");

       String str= "ananya";
       char[] charachters = str.toCharArray();
        List<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
       for(int i = 0; i<charachters.length;i++){


          if( map.containsKey(charachters[i])){
              map.put(charachters[i], map.get(charachters[i])+1);
          }else{
              map.put(charachters[i], 1);

          }

       }

       for(Map.Entry entry: map.entrySet()){
           System.out.print(entry.getKey().toString()+entry.getValue());
       }

        for(int i = 0; i<charachters.length;i++){
            list.add(charachters[i]);
        }

    }

//    private static boolean checkForDuplicacy(int [] arr) {
//
////        Set<Integer> elements= new HashSet<>();
////        for(int i=0;i<arr.length;i++){
////            if(elements.contains(Integer.valueOf(arr[i])))
////                return true;
////            elements.add(Integer.valueOf(arr[i]));
////        }
////        return false;
//    }
}
