package ArraysQuestions;

import java.util.Scanner;

public class ChasingDragon {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String numberOfCities = s.nextLine();
        Integer N = Integer.valueOf(numberOfCities);
        String costOfNCities = s.nextLine();
        String[] costArrayString = costOfNCities.split(" ");
        String KNoOfAttacks = s.nextLine();
        Integer K = Integer.valueOf(KNoOfAttacks);
        Integer[][] arrayOfDragonAttacks = new Integer[K][2];

        //creating prefix sum array directly
        long sum = 0;
        Long[] prefixSumArray = new Long[N+1];
        for(int i = 0; i<N ;i++) {
            sum = sum + Integer.valueOf(costArrayString[i]);
            prefixSumArray[i] = sum;
        }

        //inputing array of dragon attacks
        for(int i = 0; i <K; i++) {

            String dirAndPositionOfAttack = s.nextLine();
            String[] arrayOfDirANdPosition = dirAndPositionOfAttack.split(" ");
            arrayOfDragonAttacks[i][0] = Integer.valueOf(arrayOfDirANdPosition[0]);
            arrayOfDragonAttacks[i][1] = Integer.valueOf(arrayOfDirANdPosition[1]);

        }
        s.close();

        long currentPosition = 1;
        long prevPosition = 1;

        //for every atcak checking previous poition and current position and fetchinh answer from prefix sum
        for(int i = 0; i<K ;i++) {

        if(arrayOfDragonAttacks[i][1]==N) {
            System.out.println(0);
            continue;
        }
        if(arrayOfDragonAttacks[i][0] == 1)
            {

                currentPosition = (arrayOfDragonAttacks[i][1] + prevPosition) % N;

            } else {

            if(N-arrayOfDragonAttacks[i][1]<0 && Math.abs((N-arrayOfDragonAttacks[i][1])%N) - prevPosition > 0){
                currentPosition = N - (Math.abs((N-arrayOfDragonAttacks[i][1])%N) - prevPosition);
            }  else if (N-arrayOfDragonAttacks[i][1]<0 && Math.abs((N-arrayOfDragonAttacks[i][1])%N) - prevPosition < 0){
                currentPosition = prevPosition - (Math.abs((N-arrayOfDragonAttacks[i][1])%N));

            } else
                currentPosition = (N-arrayOfDragonAttacks[i][1] + prevPosition) % N;
            }
            if(currentPosition == 0) ///to counter mod
                 currentPosition = N;
            //minimum distance from both sides
            long distance1 = Math.abs(prefixSumArray[Math.toIntExact(currentPosition - 1)] - prefixSumArray[Math.toIntExact(prevPosition-1)]);
            System.out.println(Math.min(distance1, Math.abs(prefixSumArray[N-1] - distance1)));
            prevPosition = currentPosition;
        }
    }
}

//import java.util.Scanner;
//public class Go{
//    public static void main(String args[]){
//        Scanner sc=new Scanner(System.in);
//        long n=sc.nextLong();
//        long [] arr=new long[(int) n];
//        arr[0]=sc.nextLong();
//        for (long i = 1; i <n ; i++) {
//            arr[(int)i]=arr[(int)i-1]+sc.nextLong();
//        }
//        long maxCost=arr[(int)n-1];
//        long k=sc.nextLong();
//        long []dist=new long[(int)k];
//        for (long i = 0; i <k; i++) {
//            long direction=sc.nextLong();
//            long d=(long)(sc.nextLong()%(long)n);
//            if(direction==-1){
//                d=n-d;
//            }
//            dist[(int)i]=d;
//        }
//        long me=0,drgn=0,j=0;
//        while(j<k){
//            drgn=(drgn+dist[(int)j])%n;
//            long oneWayCost=Math.abs(arr[(int)drgn]-arr[(int)me]);
//            System.out.println(Math.min(oneWayCost,maxCost-oneWayCost));
//            me=drgn;
//            j++;
//        }
//
//
//    }
//}