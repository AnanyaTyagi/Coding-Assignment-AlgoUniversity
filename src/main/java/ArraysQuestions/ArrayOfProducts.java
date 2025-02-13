package ArraysQuestions;

public class ArrayOfProducts {

        public int[] arrayOfProducts(int[] array) {

            int[] results = new int[array.length];
            results[0]=1;
            for(int i = 1; i<array.length;i++){
                results[i]=results[i-1]*array[i-1];
            }
            int previous = 1;
            for(int i = array.length-2; i>=0;i--){
                previous*=array[i+1];
                results[i]*= previous;
            }
            return results;
        }

}
