class Solution {

    // 4 possible directions (up, down, left, right)
    private final int[][] dir = {
        { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    // Check if (i, j) is inside grid bounds
    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        // dist[i][j] = minimum effort required to reach cell (i, j)
        int[][] dist = new int[n][m];

        // Initialize all cells with "infinity"
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Min Heap (PriorityQueue)
        // Stores {effort, row, col}
        // Always processes the cell with smallest effort first
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
        );

        // Start from (0,0) with effort = 0
        q.offer(new int[] { 0, 0, 0 });
        dist[0][0] = 0;

        // Standard Dijkstra loop
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int effort = curr[0]; // current path effort (max edge so far)
            int ci = curr[1];     // current row
            int cj = curr[2];     // current column

            // If destination reached → this is minimum effort path
            if (ci == n - 1 && cj == m - 1) {
                return effort;
            }

            // Skip if we already found a better path to this cell
            if (effort > dist[ci][cj])
                continue;

            // Explore all 4 directions
            for (int[] d : dir) {

                int ni = ci + d[0]; // next row
                int nj = cj + d[1]; // next column

                if (isValid(ni, nj, n, m)) {

                    // Edge cost = absolute height difference
                    int edgeCost = Math.abs(heights[ci][cj] - heights[ni][nj]);

                    // Minimax logic:
                    // effort = maximum edge cost along the path
                    int newEffort = Math.max(edgeCost, effort);

                    // Relaxation:
                    // If this path gives smaller effort → update
                    if (newEffort < dist[ni][nj]) {

                        dist[ni][nj] = newEffort;

                        // Push updated state into min heap
                        q.offer(new int[] { newEffort, ni, nj });
                    }
                }
            }
        }

        // In case no path exists (not possible per constraints)
        return 0;
    }
}