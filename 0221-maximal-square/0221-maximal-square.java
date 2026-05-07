class Solution {
    int[][] dp;
    int maxSide = 0;

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];

        // initialize DP table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Try every cell as a starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                solve(i, j, matrix);
            }
        }

        return maxSide * maxSide; // area
    }

    private int solve(int i, int j, char[][] matrix) {
        if (i >= matrix.length || j >= matrix[0].length)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (matrix[i][j] == '0') {
            return dp[i][j] = 0;
        }

        int down = solve(i + 1, j, matrix);
        int right = solve(i, j + 1, matrix);
        int diag = solve(i + 1, j + 1, matrix);

        dp[i][j] = 1 + Math.min(down, Math.min(right, diag));
        maxSide = Math.max(maxSide, dp[i][j]);

        return dp[i][j];
    }
}
