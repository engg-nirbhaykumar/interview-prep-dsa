class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows
        int n = matrix.length;

        // Number of columns
        int m = matrix[0].length;

        // Start from the top-right corner of the matrix
        int row = 0;
        int col = m - 1;

        // Traverse the matrix until row and column pointers are valid
        while (row < n && col >= 0) {

            // If current element matches target, return true
            if (matrix[row][col] == target) {
                return true;
            }
            // If current element is smaller than target,
            // move down to increase the value
            else if (matrix[row][col] < target) {
                row++;
            }
            // If current element is greater than target,
            // move left to decrease the value
            else {
                col--;
            }
        }

        // Target not found in the matrix
        return false;
    }
}
