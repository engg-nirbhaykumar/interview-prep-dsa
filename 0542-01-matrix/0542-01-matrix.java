class Solution {

    // 4 possible directions: down, right, left, up
    private final int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    // Check if the cell is inside bounds AND not visited yet (i.e., result == -1)
    private boolean isValid(int i, int j, int n, int m, int[][] result) {
        return i >= 0 && i < n && j >= 0 && j < m && result[i][j] == -1;
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] result = new int[n][m];

        // Queue for BFS (Multi-source BFS)
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Initialize queue with all 0s (multi-source)
        // and mark all 1s as unvisited (-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    // Distance of 0 from nearest 0 is 0 itself
                    result[i][j] = 0;

                    // Add all 0s to queue as starting points
                    q.offer(new int[] { i, j });

                } else {
                    // Mark 1s as unvisited initially
                    result[i][j] = -1;
                }
            }
        }

        // Step 2: BFS traversal
        // Start expanding from all 0s simultaneously
        while (!q.isEmpty()) {

            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];

            // Explore all 4 directions
            for (int[] d : dirs) {

                int ni = i + d[0];
                int nj = j + d[1];

                // If neighbor is valid and unvisited
                if (isValid(ni, nj, n, m, result)) {

                    // Distance = current cell distance + 1
                    result[ni][nj] = result[i][j] + 1;

                    // Push into queue for further expansion
                    q.offer(new int[] { ni, nj });
                }
            }
        }

        // Final result matrix with shortest distance to nearest 0
        return result;
    }
}