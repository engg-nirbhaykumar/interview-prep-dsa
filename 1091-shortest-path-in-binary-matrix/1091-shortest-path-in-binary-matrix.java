class Solution {

    // 8 possible movements (including diagonals)
    private final int[][] dir = {
            { -1, -1 }, { 0, 1 }, { 1, 0 }, { 0, -1 },
            { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }
    };

    // Check:
    // 1. Within grid bounds
    // 2. Cell is open (0 = free, 1 = blocked)
    private boolean isValid(int i, int j, int n, int m, int[][] grid) {
        return i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == 0;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // Edge case:
        // If start or destination is blocked → no path exists
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;

        // Distance array:
        // dist[i][j] stores shortest distance to reach (i,j)
        int[][] dist = new int[n][m];

        // Initialize all distances to infinity
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Min Heap (PriorityQueue)
        // Each element: {distance, row, col}
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        // Start from (0,0) with distance = 1
        // (distance counts number of cells in path)
        q.offer(new int[] { 1, 0, 0 });
        dist[0][0] = 1;

        // Dijkstra traversal
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int d = curr[0]; // current distance
            int ci = curr[1]; // current row
            int cj = curr[2]; // current column

            // If destination reached → return shortest distance
            if (ci == n - 1 && cj == m - 1) {
                return d;
            }

            // Optimization:
            // Skip if we already found a shorter path to this cell
            if (d > dist[ci][cj])
                continue;

            // Explore all 8 directions
            for (int[] dxy : dir) {

                int ni = ci + dxy[0]; // next row
                int nj = cj + dxy[1]; // next column

                // If valid cell
                if (isValid(ni, nj, n, m, grid)) {

                    // Relaxation step:
                    // If a shorter path is found → update distance
                    if (d + 1 < dist[ni][nj]) {

                        dist[ni][nj] = d + 1;

                        // Push updated state into min heap
                        q.offer(new int[] { d + 1, ni, nj });
                    }
                }
            }
        }

        // If destination is unreachable
        return -1;
    }
}