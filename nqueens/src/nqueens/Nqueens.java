package nqueens;
import java.util.*;

public class Nqueens {

    int x;

    public boolean canPlaceQueen(Nqueens[] q,int r, int c) {
        for (int i = 0; i < r; i++) {
            if (q[i].x == c || (i - r) == (q[i].x - c) ||(i - r) == (c - q[i].x)) 
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println("Enter an integer:");
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        Chessboard C = new Chessboard(y);
        C.callplaceNqueens();
     
    }
}