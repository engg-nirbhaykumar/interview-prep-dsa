class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows in the matrix
        int n = matrix.length;

        // Number of columns in the matrix
        int m = matrix[0].length;

        // Treat the 2D matrix as a flattened sorted array of size n*m
        int low = 0;
        int high = n * m - 1;

        // Binary search on the virtual 1D array
        while (low <= high) {

            // Calculate mid index safely
            int mid = low + (high - low) / 2;

            // Convert 1D index back to 2D coordinates
            // Row index = mid / m
            // Column index = mid % m
            int midElement = matrix[mid / m][mid % m];

            // If target is found
            if (midElement == target) {
                return true;
            }
            // If mid element is smaller, search right half
            else if (midElement < target) {
                low = mid + 1;
            }
            // If mid element is larger, search left half
            else {
                high = mid - 1;
            }
        }

        // Target not found in the matrix
        return false;
    }
}
