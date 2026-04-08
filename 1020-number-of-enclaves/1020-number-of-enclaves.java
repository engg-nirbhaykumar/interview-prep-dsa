class Solution {

    // 4 directions: down, right, up, left
    private final int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    // Check if the next cell is valid:
    // 1. Within bounds
    // 2. Cell contains land (1)
    private boolean isValid(int ni, int nj, int n, int m, int[][] grid) {
        return (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 1);
    }

    // DFS to mark all land connected to boundary as water (0)
    private void dfs(int ci, int cj, int n, int m, int[][] grid) {

        // Mark current cell as visited (convert land → water)
        grid[ci][cj] = 0;

        // Explore all 4 directions
        for (int[] d : dirs) {
            int ni = ci + d[0]; // next row
            int nj = cj + d[1]; // next column

            // If valid land cell, continue DFS
            if (isValid(ni, nj, n, m, grid)) {
                dfs(ni, nj, n, m, grid);
            }
        }
    }

    // Count remaining land cells (these are enclaves)
    private int count(int n, int m, int[][] grid) {
        int ans = 0;

        // Traverse entire grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Count land cells
                if (grid[i][j] == 1)
                    ans++;
            }
        }

        return ans;
    }

    public int numEnclaves(int[][] grid) {

        // Edge case: empty grid
        if (grid == null || grid.length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;

        // Step 1: Remove land connected to LEFT and RIGHT boundaries
        for (int i = 0; i < n; i++) {

            int j = 0; // left boundary
            if (isValid(i, j, n, m, grid)) {
                dfs(i, j, n, m, grid);
            }

            j = m - 1; // right boundary
            if (isValid(i, j, n, m, grid)) {
                dfs(i, j, n, m, grid);
            }
        }

        // Step 2: Remove land connected to TOP and BOTTOM boundaries
        for (int j = 0; j < m; j++) {

            int i = 0; // top boundary
            if (isValid(i, j, n, m, grid)) {
                dfs(i, j, n, m, grid);
            }

            i = n - 1; // bottom boundary
            if (isValid(i, j, n, m, grid)) {
                dfs(i, j, n, m, grid);
            }
        }

        // Step 3: Count remaining land (enclaves)
        return count(n, m, grid);
    }
}