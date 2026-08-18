class Solution {

    // Stores all valid N-Queens board configurations
    List<List<String>> result;

    // Size of the chessboard (N x N)
    int N;

    // Checks whether placing a Queen at (row, col) is safe
    private boolean isValid(char[][] board, int row, int col) {

        // Check the same column in previous rows
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Safe position
        return true;
    }

    // Backtracking function to place queens row by row
    private void backTrack(char[][] board, int row) {

        // Base case: all queens placed successfully
        if (row == N) {
            List<String> config = new ArrayList<>();

            // Convert board rows to string format
            for (char[] r : board) {
                config.add(new String(r));
            }

            result.add(config);
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < board[0].length; col++) {

            // Check if position is valid
            if (isValid(board, row, col)) {

                // Place queen
                board[row][col] = 'Q';

                // Recur for next row
                backTrack(board, row + 1);

                // Backtrack: remove queen
                board[row][col] = '.'; 
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        N = n;
        result = new ArrayList<>();

        // Initialize empty board
        char[][] board = new char[N][N];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Start backtracking from row 0
        backTrack(board, 0);

        return result;
    }
}
