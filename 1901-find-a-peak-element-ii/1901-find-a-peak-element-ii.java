class Solution {
    public int[] findPeakGrid(int[][] mat) {

        // Number of rows
        int n = mat.length;

        // Number of columns
        int m = mat[0].length;

        // Binary search space on columns
        int low = 0;
        int high = m - 1;

        // Perform binary search on columns (similar to 1D peak search)
        while (low <= high) {

            // Pick middle column
            int midCol = low + (high - low) / 2;

            // Find the row index of the maximum element in midCol
            // This guarantees the element is greater than its vertical neighbors
            int maxRow = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            // Get left neighbor value (or -1 if out of bounds)
            int leftVal = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;

            // Get right neighbor value (or -1 if out of bounds)
            int rightVal = (midCol + 1 < m) ? mat[maxRow][midCol + 1] : -1;

            // If current element is greater than both horizontal neighbors,
            // then it is a peak element
            if (mat[maxRow][midCol] > leftVal &&
                mat[maxRow][midCol] > rightVal) {
                return new int[] { maxRow, midCol };
            }

            // If left neighbor is smaller, slope is increasing towards right
            // so a peak must exist in the right half
            else if (mat[maxRow][midCol] > leftVal) {
                low = midCol + 1;
            }

            // Otherwise, slope is decreasing, so move to the left half
            else {
                high = midCol - 1;
            }
        }

        // As per problem constraints, a peak always exists
        return new int[] { -1, -1 };
    }
}
