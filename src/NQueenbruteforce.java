public class NQueenbruteforce {

    public static void main(String[] args) {
        int N;
        N = 4;
        int[][] array = new int[N][N];
        System.out.println(N);
        solutionForQueens(array,N);
        printSolution(array);
    }

    static void printSolution(int[][] board) {
        int N = 4;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void solutionForQueens(int[][] array, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean b = safePlace(array,i,j);
                System.out.println("Boolean" + b + "i , j" + i +"," + j);
                if(b){
                    array[i][j] = 1;
                }

            }
        }

    }

    private static boolean safePlace(int[][] array, int row, int column) {
        boolean b;
        //same row or column
        for (int i = 0; i < column; i++) {

                if (array[row][i] == 1) {
                    return false;
                }
            }

        for (int i = 0; i <= row; i++) {
            if (array[i][column] == 1) {
                b = false;
                return b;
            }
        }


        /**   0  1  2 3
         *  0 [x  y     ]   x =0 y = 0  ||  x = 0 y= 0
         *  1 |  x  y   |   x= 1 y = 1  ||  x = 1  y= 1
         *  2 |    x  y |   x = 2 y =2  ||  x = 2   y =2
         *  3 [       x ]    x = 3 y = 3 ||
         */
        for (int i = row , j = column; j>= 0 && i >= 0; i--, j--) {

                if (array[i][j] == 1) {
                    return false;
                }
            }


        return true;
    }
}
