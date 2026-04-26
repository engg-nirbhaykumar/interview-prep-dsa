class Solution {

    // Recursive function with memoization
    // row, col -> current position in the grid
    // m, n     -> grid dimensions
    private int solve(int row, int col, int m, int n, int[][] dp) {

        // If out of bounds, no valid path
        if (row >= m || col >= n)
            return 0;

        // If destination is reached, count as one valid path
        if (row == m - 1 && col == n - 1)
            return 1;

        // If already computed, return stored result
        if (dp[row][col] != -1)
            return dp[row][col];

        // Move right
        int right = solve(row, col + 1, m, n, dp);

        // Move down
        int down = solve(row + 1, col, m, n, dp);

        // Store and return total paths from current cell
        return dp[row][col] = right + down;
    }

    public int uniquePaths(int m, int n) {

        // DP table to store results for each cell
        int[][] dp = new int[m][n];

        // Initialize with -1 (means not yet computed)
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        // Start from top-left corner (0,0)
        return solve(0, 0, m, n, dp);
    }
}