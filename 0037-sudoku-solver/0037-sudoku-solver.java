class Solution {

    private boolean isValid(char[][] board, int row, int col, char d) {

        // Check row & column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == d)
                return false;
            if (board[i][col] == d)
                return false;
        }

        // Check 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[startRow + r][startCol + c] == d)
                    return false;
            }
        }

        return true;
    }

    private boolean backTrack(char[][] board) {

        // Find empty cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') { // Only solve empty cells

                    // Try digits 1–9
                    for (char d = '1'; d <= '9'; d++) {

                        if (isValid(board, i, j, d)) {

                            board[i][j] = d; // Place digit

                            if (backTrack(board)) // Recurse
                                return true;

                            board[i][j] = '.'; // Backtrack
                        }
                    }

                    // If no digit worked → dead end
                    return false;
                }
            }
        }

        // No empty cells left → solved
        return true;
    }

    public void solveSudoku(char[][] board) {
        backTrack(board);
    }
}
