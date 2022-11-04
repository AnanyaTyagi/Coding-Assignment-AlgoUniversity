package WarmUp;

import java.util.Scanner;

public class WhiteLuckWarrior {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String positionsOfFirstRect = s.nextLine();
        String positionsOfSecondRect = s.nextLine();
        s.close();
        String[] positionArrayOfFirstRect = positionsOfFirstRect.split(" ");
        String[] positionArrayOfSecondRect = positionsOfSecondRect.split(" ");

        Integer x11 = Integer.valueOf(positionArrayOfFirstRect[0]);
        Integer y11 = Integer.valueOf(positionArrayOfFirstRect[1]);
        Integer x12 = Integer.valueOf(positionArrayOfFirstRect[2]);
        Integer y12 = Integer.valueOf(positionArrayOfFirstRect[3]);

        Integer x21 = Integer.valueOf(positionArrayOfSecondRect[0]);
        Integer y21 = Integer.valueOf(positionArrayOfSecondRect[1]);
        Integer x22 = Integer.valueOf(positionArrayOfSecondRect[2]);
        Integer y22 = Integer.valueOf(positionArrayOfSecondRect[3]);

        Integer aX = Math.abs(x11-x12);
        Integer bX = Math.abs(x11-x22);
        Integer cX = Math.abs(x21-x22);
        Integer dX = Math.abs(x21-x12);

        Integer aY =  Math.abs(y21-y22);
        Integer bY = Math.abs(y11-y22);
        Integer cY = Math.abs(y11-y12);
        Integer dY = Math.abs(y21-y12);


        Integer maxX = aX > bX ? (aX > cX ? aX : cX) : (bX> cX ? bX : cX);
        Integer maxY = aY > bY ? (aY > cY ? aY : cY) : (bY> cY ? bY : cY);

        Integer solutionSide = Math.max(Math.max(maxX, dX), Math.max(maxY, dY));
        Integer solution = solutionSide * solutionSide;

        System.out.println(solution);

    }
}
