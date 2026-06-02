class Solution {
    int n; // number of rows
    int m; // number of cols
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int[][] dp; // memo table: dp[i][j] = longest path starting from (i, j)

    // DFS with memoization
    private int dfs(int i, int j, int[][] matrix) {
        // If already computed, return cached result
        if (dp[i][j] != 0)
            return dp[i][j];

        int maxLen = 1; // At least the current cell counts as length 1

        // Explore all 4 directions
        for (int[] d : dirs) {
            int ni = i + d[0]; // next row
            int nj = j + d[1]; // next col

            // Check boundaries and increasing condition
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && matrix[ni][nj] > matrix[i][j]) {
                // Add +1 for current cell and recurse
                maxLen = Math.max(maxLen, 1 + dfs(ni, nj, matrix));
            }
        }

        // Store result in dp table
        dp[i][j] = maxLen;
        return maxLen;
    }

    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m]; // Initialize dp with 0 (uncomputed)

        int maxPath = 0;

        // Try starting DFS from every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPath = Math.max(maxPath, dfs(i, j, matrix));
            }
        }

        return maxPath;
    }
}
