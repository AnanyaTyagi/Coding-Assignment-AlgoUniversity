package ArraysQuestions;

public class BayerMooreMajorityElement {

    public int majorityElement(int[] array) {
        //Bayer Moore's algorithm assuming that there is always a majority element
        int result = 0;
        int answer = array[0];
        int countMax  = 1;
        for(int i = 1; i < array.length; i++){
            if(countMax == 0){
                answer = array[i];
                countMax = 1;
                continue;
            }
            if(answer == array[i]){
                countMax++;
            } else {

                countMax--;

            }


        }
        return answer;
    }
}
