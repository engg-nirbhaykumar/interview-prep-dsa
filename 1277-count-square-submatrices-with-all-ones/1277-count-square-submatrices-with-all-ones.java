class Solution {

    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // dp[i][j] stores:
        // the size of the largest square submatrix
        // starting from cell (i, j)
        int[][] dp = new int[m][n];

        // Initialize DP array with -1
        // -1 means "not calculated yet"
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = 0;

        // Try every cell as the top-left corner
        // of a square submatrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Add number of squares possible
                // starting from (i, j)
                result += solve(i, j, matrix, dp);
            }
        }

        return result;
    }

    private int solve(int i, int j, int[][] matrix, int[][] dp) {

        // Out of bounds -> no square possible
        if (i >= matrix.length || j >= matrix[0].length)
            return 0;

        // Return already computed result
        if (dp[i][j] != -1)
            return dp[i][j];

        // If current cell is 0,
        // square cannot start here
        if (matrix[i][j] == 0) {
            return dp[i][j] = 0;
        }

        // Find largest square sizes in:
        // down cell
        int down = solve(i + 1, j, matrix, dp);

        // right cell
        int right = solve(i, j + 1, matrix, dp);

        // diagonal cell
        int diag = solve(i + 1, j + 1, matrix, dp);

        // Current cell contributes 1 square itself,
        // and larger square depends on minimum
        // among down, right, and diagonal
        //
        // Example:
        // If min = 2, then current cell can form
        // a square of size 3
        return dp[i][j] = 1 + Math.min(down, Math.min(right, diag));
    }
}