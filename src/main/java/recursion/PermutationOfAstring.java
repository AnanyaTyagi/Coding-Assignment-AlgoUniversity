package recursion;

import java.util.Scanner;

public class PermutationOfAstring {
    public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      String string = sc.nextLine();
      char[] s = string.toCharArray();
      int frequency[] = new int[27];
      if(string.length()==1){
          System.out.println(string);
          System.exit(0);
      }

      for(int i = 0; i<string.length() ;i++){
          frequency[s[i]-'a']++;
      }
      
      permutation("", frequency);
    }

    private static void permutation(String temp, int[] freq) {
        System.out.println(" recur ");
      int sum = 0;
      for(int i = 0; i<26; i++){
          sum+=freq[i];
          if(freq[i]>0){
              System.out.print(freq[i]+" ");
              freq[i]--;
              temp+=((char)(i+'a'));
              System.out.print(temp);
              permutation(temp, freq);
              freq[i]++;
              temp = temp.substring(0, temp.length()-1);
          }
      }
       if(sum == 0){
           System.out.println(temp);
       }
    }
}
