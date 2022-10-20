import java.util.Scanner;

public class GreatOrdeal {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String stringOfPositions = s.nextLine();
        s.close();
        String[] arrayOfPositions = stringOfPositions.split(" ");
        Integer a = Integer.valueOf(arrayOfPositions[0]);
        Integer b = Integer.valueOf(arrayOfPositions[1]);
        Integer c = Integer.valueOf(arrayOfPositions[2]);

       Integer gap1 =Math.abs(a-b)-1;
       Integer gap2 =Math.abs(b-c)-1;
       Integer min = 0;
       Integer max = 0;

       if( gap1 == 0 && gap2 == 0){
                min = 0;
       } else if ((gap1 == 1 && gap2 == 0 )|| (gap2 == 1 && gap1 == 0)){
           min = 1;
       } else if ((gap1 > 1 && gap2 == 0 )|| (gap2 > 1 && gap1 == 0)){
           min = 2;
       }else if ((gap1 > 1 && gap2 == 1 )|| (gap2 > 1 && gap1 == 1)){
           min = 1;
       }else if( gap1 == 1 && gap2 == 1){
            min = 1;
        }else if( gap1 > 1 && gap2 > 1){
           min = 2;
       }

       max = Math.max(Math.abs(a-b), Math.abs(b-c)) -1;
        System.out.println(min);
        System.out.println(max);

    }
}
