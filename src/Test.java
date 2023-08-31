public class Test {
    static int N = 4; // Change N to the desired board size

    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isSafe(int[][] board, int row, int col) {
        // Check the row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower left diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    static void solveNQueens() {
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }

        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                if (isSafe(board, row, col)) {
                    board[row][col] = 1;

                    if (col == N - 1) {
                        printSolution(board);
                    }

                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        solveNQueens();
    }
}