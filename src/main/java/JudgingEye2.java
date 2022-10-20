import java.util.Scanner;

public class JudgingEye2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String stringOfPositions = s.nextLine();
        s.close();
        String[] arrayOfPositions = stringOfPositions.split(" ");
        Integer x = Integer.valueOf(arrayOfPositions[0]);
        Integer y = Integer.valueOf(arrayOfPositions[1]);
        Integer a = Integer.valueOf(arrayOfPositions[2]);
        Integer b = Integer.valueOf(arrayOfPositions[3]);
        Integer ans1 =Math.abs(x-a) + Math.abs(b-y);
        Integer ans2 =Math.abs(x-b) + Math.abs(y-a);

        Integer minPath =Math.abs(x-y)<(ans1)?(Math.abs(x-y)> ans2 ? ans2 : Math.abs(x-y)):((ans1)> ans2?ans2 :ans1);

        System.out.println(minPath);
    }
}

