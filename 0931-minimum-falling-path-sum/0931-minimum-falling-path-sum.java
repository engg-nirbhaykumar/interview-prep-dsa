class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        /*
         * prev[j] =
         * Minimum falling path sum
         * reaching column j in previous row
         */
        int[] prev = new int[n];

        // Initialize first row
        // Since path starts from first row itself
        for (int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }

        // Process rows from top to bottom
        for (int i = 1; i < m; i++) {

            /*
             * curr[j] =
             * Minimum falling path sum
             * reaching column j in current row
             */
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {

                /*
                 * From current cell,
                 * we can come from:
                 * 1. Top-left     -> prev[j-1]
                 * 2. Top          -> prev[j]
                 * 3. Top-right    -> prev[j+1]
                 */

                curr[j] = matrix[i][j]
                        + Math.min(
                                Math.min(
                                        prev[Math.max(0, j - 1)], // top-left
                                        prev[j]                   // top
                                ),
                                prev[Math.min(n - 1, j + 1)]   // top-right
                        );
            }

            // Move current row to previous row
            prev = curr;
        }

        // Find minimum value in last row
        int minVal = Integer.MAX_VALUE;

        for (int val : prev) {
            minVal = Math.min(minVal, val);
        }

        return minVal;
    }
}