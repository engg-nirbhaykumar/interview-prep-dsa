class Solution {

    // Recursive function with memoization
    // row, col        -> current position in the grid
    // m, n            -> grid dimensions
    // dp              -> memoization table
    // obstacleGrid    -> grid with obstacles (1 = blocked, 0 = free)
    private int solve(int row, int col, int m, int n, int[][] dp, int[][] obstacleGrid) {

        // If out of bounds OR current cell has an obstacle, no valid path
        if (row >= m || col >= n || obstacleGrid[row][col] == 1)
            return 0;

        // If destination is reached, count as one valid path
        if (row == m - 1 && col == n - 1)
            return 1;

        // If already computed, return stored result
        if (dp[row][col] != -1)
            return dp[row][col];

        // Move right
        int right = solve(row, col + 1, m, n, dp, obstacleGrid);

        // Move down
        int down = solve(row + 1, col, m, n, dp, obstacleGrid);

        // Store and return total paths from current cell
        return dp[row][col] = right + down;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // DP table initialized with -1 (means not computed yet)
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        // Start recursion from top-left corner (0,0)
        return solve(0, 0, m, n, dp, obstacleGrid);
    }
}