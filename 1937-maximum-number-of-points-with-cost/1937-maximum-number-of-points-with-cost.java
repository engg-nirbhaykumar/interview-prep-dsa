class Solution {

    public long maxPoints(int[][] points) {

        int m = points.length;
        int n = points[0].length;

        /*
         * prev[j] =
         * Maximum points collected till previous row
         * if we end at column j
         */
        long[] prev = new long[n];

        // Initialize first row
        for (int j = 0; j < n; j++) {
            prev[j] = points[0][j];
        }

        // Process each row starting from row 1
        for (int i = 1; i < m; i++) {

            /*
             * left[j] =
             * Best value coming from left side
             *
             * While moving right,
             * score decreases by 1 for each column move
             */
            long[] left = new long[n];

            /*
             * right[j] =
             * Best value coming from right side
             */
            long[] right = new long[n];

            /*
             * curr[j] =
             * Maximum points collected till current row
             * ending at column j
             */
            long[] curr = new long[n];

            // Build left array
            left[0] = prev[0];

            for (int j = 1; j < n; j++) {

                /*
                 * Either:
                 * 1. Stay in same column -> prev[j]
                 * 2. Move from left side -> left[j-1] - 1
                 */
                left[j] = Math.max(prev[j], left[j - 1] - 1);
            }

            // Build right array
            right[n - 1] = prev[n - 1];

            for (int j = n - 2; j >= 0; j--) {

                /*
                 * Either:
                 * 1. Stay in same column -> prev[j]
                 * 2. Move from right side -> right[j+1] - 1
                 */
                right[j] = Math.max(prev[j], right[j + 1] - 1);
            }

            // Calculate best value for current row
            for (int j = 0; j < n; j++) {

                /*
                 * Add current cell points
                 * with best possible previous transition
                 */
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            }

            // Move current row to previous row
            prev = curr;
        }

        // Find maximum value in last row
        long maxVal = Long.MIN_VALUE;

        for (long val : prev) {
            maxVal = Math.max(maxVal, val);
        }

        return maxVal;
    }
}