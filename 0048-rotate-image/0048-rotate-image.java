class Solution {

    // Helper method to reverse a single row in-place (left ↔ right)
    private void reverseRow(int[] row) {
        int left = 0;
        int right = row.length - 1;

        // Swap elements until pointers cross
        while (left <= right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Step 1: Transpose the matrix
        // Swap matrix[i][j] with matrix[j][i] for all i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        // This converts the transposed matrix into its 90° rotated version
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }
}
