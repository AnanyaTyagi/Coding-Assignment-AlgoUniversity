package SearchingSorting;

import java.util.Scanner;

public class SearchingAndSorting {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        Double n = Double.valueOf(input);

        double l = 0;
        double r = 10e15;
        double diff = 10e-7;
        while(l+ diff<r) {

            double m= l + (r-l)/2;

            if(predicate(m , n)){
                l = m;
            } else {
                r = m;
            }
        }
        System.out.println(l);
    }

    public static boolean predicate(Double m, Double x) {
        if(m * m <= x) {
            return true;
        }
        return false;
    }
}
