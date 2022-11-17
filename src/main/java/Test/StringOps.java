package Test;


import java.util.Scanner;

public class StringOps {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String stringOfLetters = s.nextLine();
        char[] array = stringOfLetters.toCharArray();
        int[] arrayBinary = new int[array.length+1];

        Integer N = s.nextInt();

        for (int k = 0; k < N; k++) {
            int i = s.nextInt();
            int j = stringOfLetters.length()- i + 1;
            arrayBinary[i]++;
            arrayBinary[j]--;

        }
        for(int k = 1; k <=array.length; k++) {
            arrayBinary[k]+=arrayBinary[k-1];
          System.out.println(arrayBinary[k]);
        }

        for(int k = 1; k <=array.length/2; k++) {
            if(arrayBinary[k] % 2 == 0)
                continue;
            else {
                char t = array[k-1];
                array[k-1] = array[array.length-k];
                array[array.length-k] = t;
            }
        }

        String result = String.valueOf(array);
        System.out.print(result);
    }


    private static void reverseString(String[] array, int i, int j) {

        for(int k = i, l= j; i<=(i+j)/2 && j>(i+j)/2 ; i++, j--) {
            String t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }

//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader()
//        {
//            br = new BufferedReader(
//                    new InputStreamReader(System.in));
//        }
//
//        String next()
//        {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt() { return Integer.parseInt(next()); }
//
//        long nextLong() { return Long.parseLong(next()); }
//
//        double nextDouble()
//        {
//            return Double.parseDouble(next());
//        }
//
//        String nextLine()
//        {
//            String str = "";
//            try {
//                if(st.hasMoreTokens()){
//                    str = st.nextToken("\n");
//                }
//                else{
//                    str = br.readLine();
//                }
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
}

