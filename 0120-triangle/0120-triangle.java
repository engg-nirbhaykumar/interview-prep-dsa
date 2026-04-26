class Solution {

    // Recursive function with memoization
    // row, col -> current position in the triangle
    // n        -> total number of rows
    // dp       -> memoization table
    // triangle -> input triangle
    private int solve(int row, int col, int n, Integer[][] dp, List<List<Integer>> triangle) {

        // Out of bounds check (safety check, though usually not needed for valid inputs)
        if (row >= n || col >= n)
            return Integer.MAX_VALUE;

        // Base case: last row, return the value at current position
        if (row == n - 1)
            return triangle.get(row).get(col);

        // If already computed, return stored result
        if (dp[row][col] != null)
            return dp[row][col];

        // Move directly down
        int down = solve(row + 1, col, n, dp, triangle);

        // Move diagonally down-right
        int downRight = solve(row + 1, col + 1, n, dp, triangle);

        // Current value + minimum of the two possible paths
        return dp[row][col] = triangle.get(row).get(col) + Math.min(down, downRight);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        // DP table initialized with -1 (means not computed yet)
        Integer[][] dp = new Integer[n][n];
        // for (int[] d : dp) {
        //     Arrays.fill(d, -1);
        // }

        // Start from the top of the triangle (0,0)
        return solve(0, 0, n, dp, triangle);
    }
}