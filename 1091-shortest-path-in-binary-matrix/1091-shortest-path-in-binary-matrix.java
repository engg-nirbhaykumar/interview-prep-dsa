class Solution {

    // 8 possible directions (including diagonals)
    private final int[][] dir = {
        { -1, -1 }, { 0, 1 }, { 1, 0 }, { 0, -1 },
        { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }
    };

    // Utility function to check:
    // 1. Inside grid bounds
    // 2. Cell is not blocked (0 = free cell)
    private boolean isValid(int i, int j, int n, int m, int[][] grid) {
        return i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == 0;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Edge case:
        // If start or end is blocked → no path possible
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;

        // Queue for BFS → stores {row, col, distance}
        Queue<int[]> q = new LinkedList<>();

        // Start from (0,0) with distance = 1
        // (distance represents number of cells in path)
        q.offer(new int[] { 0, 0, 1 });

        // Mark starting cell as visited
        // (we reuse grid to avoid extra visited array)
        grid[0][0] = 1;

        // Standard BFS loop
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int ci = curr[0];   // current row
            int cj = curr[1];   // current column
            int dist = curr[2]; // distance so far

            // If we reached destination → return shortest distance
            if (ci == n - 1 && cj == m - 1) {
                return dist;
            }

            // Explore all 8 possible directions
            for (int[] d : dir) {
                int ni = ci + d[0]; // next row
                int nj = cj + d[1]; // next column

                // Check if next cell is valid and unvisited
                if (isValid(ni, nj, n, m, grid)) {

                    // Add to queue with incremented distance
                    q.offer(new int[] { ni, nj, dist + 1 });

                    // Mark as visited to avoid revisiting
                    grid[ni][nj] = 1;
                }
            }
        }

        // If BFS ends without reaching destination → no path exists
        return -1;
    }
}