class Solution {

    // 4 directions: down, right, up, left
    private final int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    // Check if the next cell is valid:
    // 1. Within grid bounds
    // 2. Cell contains land ('1')
    private boolean isValid(int ni, int nj, int n, int m, char[][] grid) {
        return (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == '1');
    }

    // DFS to mark all connected land cells as visited
    private void dfs(int ci, int cj, int n, int m, char[][] grid) {

        // Mark current cell as visited by converting '1' → '0'
        grid[ci][cj] = '0';

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

    public int numIslands(char[][] grid) {

        // Edge case: empty grid
        if (grid == null || grid.length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;

        int numOfIslands = 0; // count of islands

        // Traverse every cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // If land is found, it's a new island
                if (grid[i][j] == '1') {
                    numOfIslands++;       // increment island count
                    dfs(i, j, n, m, grid); // mark entire island as visited
                }
            }
        }

        return numOfIslands;
    }
}