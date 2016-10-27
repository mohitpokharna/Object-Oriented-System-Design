/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueensgui;

import java.util.Scanner;

/**
 *
 * @author mohit
 */
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