class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows
        int m = matrix.length;
        // Number of columns
        int n = matrix[0].length;

        // Treat the 2D matrix as a sorted 1D array
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {

            // Standard binary search mid calculation
            int mid = low + (high - low) / 2;

            // Convert mid from 1D index → 2D index:
            // Row = mid / n , Column = mid % n
            int midElement = matrix[mid / n][mid % n];

            // If mid element matches target → found
            if (midElement == target) {
                return true;
            }

            // If mid element is smaller → move right
            else if (midElement < target) {
                low = mid + 1;
            }

            // If mid element is larger → move left
            else {
                high = mid - 1;
            }
        }

        // If we exit the loop → target not found
        return false;
    }
}
