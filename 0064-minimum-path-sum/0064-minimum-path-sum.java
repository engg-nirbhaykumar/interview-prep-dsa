class Solution {

    // Recursive function with memoization
    // row, col -> current position in the grid
    // m, n     -> grid dimensions
    // dp       -> memoization table
    // grid     -> input matrix with costs
    private int solve(int row, int col, int m, int n, int[][] dp, int[][] grid) {

        // If out of bounds, return a very large value so it won't be chosen in min()
        if (row >= m || col >= n)
            return Integer.MAX_VALUE;

        // If destination is reached, return its value
        if (row == m - 1 && col == n - 1)
            return grid[row][col];

        // If already computed, return stored result
        if (dp[row][col] != -1)
            return dp[row][col];

        // Move right
        int right = solve(row, col + 1, m, n, dp, grid);

        // Move down
        int down = solve(row + 1, col, m, n, dp, grid);

        // Current cell value + minimum of right and down paths
        return dp[row][col] = grid[row][col] + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // DP table initialized with -1 (means not computed yet)
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        // Start recursion from top-left corner (0,0)
        return solve(0, 0, m, n, dp, grid);
    }
}