package LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WiggleWalk {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i<T; i++){
            int N = scanner.nextInt();
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int Sr = scanner.nextInt();
            int Sc = scanner.nextInt();
            String instructions = scanner.nextLine();
            solve(N, R, C, Sr, Sc, instructions);
        }
    }

    private static void solve(int n, int r, int c, int sr, int sc, String instructions) {
      Map<Pair, Node>  map = new  HashMap<>();
      Node node = new Node(sr, sc);
      Pair pair = new Pair(sr, sc);
      map.put(pair, node);

      for( int i = 0; i< instructions.length(); i++){
          if(!map.containsKey(new int[]{sr, sc})){
              Node nodeCurr = new Node(sr, sc);
              map.put(new Pair(sr, sc),nodeCurr);
          }
      }
    }

    static class Node{
        int[] N, S, E ,W;

        Node(int x, int y){
            N= new int[]{x - 1, y};
            S= new int[]{x + 1, y};
            E= new int[]{x, y+1};
            W= new int[]{x, y-1};
        }
    }

    static class Pair{
       int x, y;

       Pair(int a, int b){
           x = a;
           y = b;
       }
    }
}
