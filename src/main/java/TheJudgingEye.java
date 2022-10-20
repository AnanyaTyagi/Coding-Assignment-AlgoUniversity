import java.util.Scanner;

//wrong
public class TheJudgingEye {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String stringOfPositions = s.nextLine();
        s.close();
        String[] arrayOfPositions = stringOfPositions.split(" ");
        Integer x = Integer.valueOf(arrayOfPositions[0]);
        Integer y = Integer.valueOf(arrayOfPositions[1]);
        Integer a = Integer.valueOf(arrayOfPositions[2]);
        Integer b = Integer.valueOf(arrayOfPositions[3]);

        if (x == y) {
            System.out.println(1);
        } else if ((a > x && a > y && b > x && b > y) || (a == b) || (x> a && y > a && x > b && y > b)) {
            System.out.println(Math.abs(x - y));
        } else if ((a < x && y < b && x < y) || (a < y && x < b && y < x) || (b < x && y < a && y > x) || (b < y && x < a && y < x) || (a == x && b == y && b != a) || (a == y && x == b && b != a)) {
            System.out.println(1);
        } else if ((x < y && a > x && b < y && a < y && b > x) || (x > y && a > y && b < x && b > y && a < x)) {
            System.out.println(Math.abs(x - y) - Math.abs(a - b));
        } else if (y > a && x > b && y > x) {
            System.out.println(Math.abs(y - a) + 1);
        } else if (a > x && b > y && y > x) {
            System.out.println(Math.abs(x - a) + 1);
        } else if (b > x && a > y && y > x) {
            System.out.println(Math.abs(x - b) + 1);
        } else if (x > a && y > b && y > x) {
            System.out.println(Math.abs(y - b) + 1);
        } else if (y>a && x > b && x > y) {
            System.out.println(Math.abs(x - b) + 1);
        } else if (a > y && b > x && x > y) {
            System.out.println(Math.abs(y - a) + 1);
        } else if (x>b && b>y && x>y) {
            System.out.println(Math.abs(y - b) + 1);
        } else if (x > a && y > b && x > y) {
            System.out.println(Math.abs(x - a) + 1);
        }
    }
}

