class Solution {

    // 4-directional movement: right, down, left, up
    private final int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    // Check if cell is within grid bounds
    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // visited array to avoid re-processing cells
        boolean[][] visited = new boolean[n][m];

        // Min-heap (PriorityQueue)
        // Stores: {time, row, col}
        // Always processes the cell with minimum time first
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        // Start from (0,0)
        // Initial time = grid[0][0] (we must wait until water reaches this level)
        pq.offer(new int[] { grid[0][0], 0, 0 });

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int time = curr[0]; // current maximum elevation encountered so far
            int r = curr[1];
            int c = curr[2];

            // If we reached destination, return time
            // This is guaranteed to be minimum due to min-heap
            if (r == n - 1 && c == m - 1)
                return time;

            // If already visited, skip
            if (visited[r][c])
                continue;

            // Mark as visited
            visited[r][c] = true;

            // Explore all 4 directions
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (isValid(nr, nc, n, m) && !visited[nr][nc]) {

                    // The time to enter next cell is:
                    // max(current time, height of next cell)
                    // because water must rise to that level
                    int newTime = Math.max(time, grid[nr][nc]);

                    pq.offer(new int[] { newTime, nr, nc });
                }
            }
        }

        return -1; // should not happen
    }
}