/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueensgui;

import java.util.ArrayList;

/**
 *
 * @author mohit
 */
public class Chessboard {
    
    private final Nqueens[] q;
    int z=1;
    ArrayList<Chessboardgui> solutions;
    
    public Chessboard(int N) {
        this.solutions = new ArrayList<>();
        q = new Nqueens[N];
        for(int i=0;i<N;++i) {
            q[i] = new Nqueens();
        }
    }

    public void addSolution(Nqueens[] q) {
        int N = q.length;
        Chessboardgui solution = new Chessboardgui(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q[i].x == j) {
                    solution.setBoardLayout(i, j, 1);
                } else {
                    solution.setBoardLayout(i, j, 0);
                }
            }
        }
        solutions.add(solution);
    }
    
    public void placeNqueens(Nqueens[] q,int k, int n) {
        for (int c=0; c<n; ++c) {
            if (q[k].canPlaceQueen(q,k,c)) {
                q[k].x = c;
                if (k==n-1) {
                    addSolution(q);
                } else {
                    placeNqueens(q,k+1,n);
                }
            }
        }
    }

    
    public void callplaceNqueens() {
        placeNqueens(q,0, q.length);
    }

}