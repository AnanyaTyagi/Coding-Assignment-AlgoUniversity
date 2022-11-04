package WarmUp;

import java.util.Scanner;

public class TheUnholyConsult {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String stringOfPositions = s.nextLine();
        String[] arrayOfPositions = stringOfPositions.split(" ");

        Integer n = Integer.valueOf(arrayOfPositions[0]);
        Integer m = Integer.valueOf(arrayOfPositions[1]);

        Integer a = n;
        Integer b = m;

        Integer[][] nArr = new Integer[n][2];
        Integer[][] mArr = new Integer[m][2];

        Integer[][] nArrExtended = new Integer[100][2];
        Integer[][] mArrExtended = new Integer[100][2];

        int index = 0;
        while (a != 0) {

            String distSpeedString = s.nextLine();
            String[] distSpeedArr = distSpeedString.split(" ");
            nArr[index][0] = Integer.valueOf(distSpeedArr[0]);
            nArr[index][1] = Integer.valueOf(distSpeedArr[1]);
            index++;
            --a;

        }
        index = 0;
        while (b != 0) {

            String distSpeedString = s.nextLine();
            String[] distSpeedArr = distSpeedString.split(" ");
            mArr[index][0] = Integer.valueOf(distSpeedArr[0]);
            mArr[index][1] = Integer.valueOf(distSpeedArr[1]);
            index++;
            --b;
        }
        s.close();

        Integer indexN = 0;
        for (int i = 0; i < nArr.length; i++) {
            int j = 0;
            for (j = indexN; j < indexN + nArr[i][0]; j++)
            nArrExtended[j][0] = nArr[i][1];

            indexN = j;
        }

        Integer indexM = 0;
        for (int i=0; i < mArr.length; i++) {
            int j =0;
            for (j = indexM; j < indexM + mArr[i][0]; j++)
                mArrExtended[j][0] = mArr[i][1];
            indexM = j;
        }

        Integer maxDiff = 0;
        for (int i = 0; i < 100; i++) {
            if(mArrExtended[i][0] - nArrExtended[i][0] > maxDiff) {
                maxDiff = mArrExtended[i][0] - nArrExtended[i][0];
            }
        }
        System.out.println(maxDiff);
    }
}
