package BFS;
import java.util.Scanner;

public class BigDisc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int X = scanner.nextInt(); // X coordinate of the top-right vertex
            int Y = scanner.nextInt(); // Y coordinate of the top-right vertex
            int n = scanner.nextInt(); // Number of circles

            boolean canReachDestination = canReachDestination(X, Y, n, scanner);
            System.out.println(canReachDestination ? "YES" : "NO");
        }

        scanner.close();
    }

    private static boolean canReachDestination(int X, int Y, int n, Scanner scanner) {
        for (int j = 0; j < n; j++) {
            int cX = scanner.nextInt(); // X coordinate of circle center
            int cY = scanner.nextInt(); // Y coordinate of circle center
            int r = scanner.nextInt();  // Radius of the circle

            // Check if circle lies in the path to the destination
            if ((cX - X) * (cX - X) + (cY - Y) * (cY - Y) <= r * r) {
                return false; // We can't reach the destination if any circle obstructs the path
            }
        }
        return true; // If no circle obstructs the path, we can reach the destination
    }
}

