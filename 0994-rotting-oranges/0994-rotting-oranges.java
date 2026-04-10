class Solution {

    // 4 directions: right, down, left, up
    private final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    // Check if cell is inside grid and contains a fresh orange
    private boolean isValid(int i, int j, int n, int m, int[][] grid) {
        return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1;
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // Count of fresh oranges
        int fresh = 0;

        // Queue for BFS (stores all rotten oranges initially)
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Initialize queue with all rotten oranges (multi-source)
        // and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    // Add all rotten oranges to queue
                    q.offer(new int[] { i, j });

                } else if (grid[i][j] == 1) {
                    // Count fresh oranges
                    fresh++;
                }
            }
        }

        // If no fresh oranges, no time needed
        if (fresh == 0)
            return 0;

        // Time taken to rot all oranges
        int time = 0;

        // Step 2: BFS level order traversal
        while (!q.isEmpty()) {

            // Process one level at a time (one minute)
            int size = q.size();

            for (int k = 0; k < size; k++) {

                int[] node = q.poll();
                int ci = node[0];
                int cj = node[1];

                // Traverse all 4 directions
                for (int[] d : dirs) {

                    int ni = ci + d[0];
                    int nj = cj + d[1];

                    // If neighbor is a fresh orange
                    if (isValid(ni, nj, n, m, grid)) {

                        // Rot the fresh orange
                        grid[ni][nj] = 2;

                        // Decrease fresh count
                        fresh--;

                        // Add to queue for next level processing
                        q.offer(new int[] { ni, nj });
                    }
                }
            }

            // After processing one level, increment time
            time++;
        }

        // If all oranges became rotten, return time - 1
        // because last increment happens after final spread
        // If some fresh oranges remain, return -1
        return fresh == 0 ? time - 1 : -1;
    }
}