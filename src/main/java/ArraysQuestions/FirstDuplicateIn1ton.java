package ArraysQuestions;

public class FirstDuplicateIn1ton {

        public int firstDuplicateValue(int[] array) {
            // Write your code here.
            int index;
            for(int i = 0;i<array.length;i++){
                index = Math.abs(array[i])-1;
                if(array[index]<0)
                    return Math.abs(array[i]);
                array[index]*=-1;
            }
            return -1;
        }

}
