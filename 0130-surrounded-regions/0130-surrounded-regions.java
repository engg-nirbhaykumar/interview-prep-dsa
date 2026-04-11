class Solution {

    // 4 possible directions: right, down, left, up
    private final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    // Check if cell is inside grid and contains 'O'
    private boolean isValid(int i, int j, int m, int n, char[][] board) {
        return i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'O';
    }

    // DFS to mark all 'O's connected to boundary as 'T'
    private void dfs(int i, int j, int m, int n, char[][] board) {

        // Mark current cell as temporary (safe)
        board[i][j] = 'T';

        // Explore all 4 directions
        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];

            // If neighbor is valid 'O', continue DFS
            if (isValid(ni, nj, m, n, board)) {
                dfs(ni, nj, m, n, board);
            }
        }
    }

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Edge case: empty board
        if (m == 0 || n == 0)
            return;

        // Step 1: Traverse first and last column
        // Mark all boundary-connected 'O' as 'T'
        for (int i = 0; i < m; i++) {

            int j = 0; // first column
            if (board[i][j] == 'O') {
                dfs(i, j, m, n, board);
            }

            j = n - 1; // last column
            if (board[i][j] == 'O') {
                dfs(i, j, m, n, board);
            }
        }

        // Step 2: Traverse first and last row
        // Mark all boundary-connected 'O' as 'T'
        for (int j = 0; j < n; j++) {

            int i = 0; // first row
            if (board[i][j] == 'O') {
                dfs(i, j, m, n, board);
            }

            i = m - 1; // last row
            if (board[i][j] == 'O') {
                dfs(i, j, m, n, board);
            }
        }

        // Step 3: Final conversion
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Convert temporary marks back to 'O'
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }

                // Convert remaining 'O' (captured regions) to 'X'
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}