package nqueens;

public class Chessboard {
    
    private final Nqueens[] q;
    int z=1;
    
    public Chessboard(int N) {
        q = new Nqueens[N];
        for(int i=0;i<N;++i) {
            q[i] = new Nqueens();
        }
    }

    public void printQueens(Nqueens[] q) {
        int N = q.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q[i].x == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void placeNqueens(Nqueens[] q,int k, int n) {
        for (int c=0; c<n; ++c) {
            if (q[k].canPlaceQueen(q,k,c)) {
                q[k].x = c;
                if (k==n-1) {
                    System.out.println(z++);
                    printQueens(q);
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

