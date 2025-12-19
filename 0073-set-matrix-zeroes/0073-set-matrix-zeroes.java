class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Flags to remember whether first row or first column
        // originally contained any zero
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        // Check if first row has any zero
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        // Check if first column has any zero
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        // Use first row and first column as markers
        // If matrix[i][j] == 0, mark its row and column
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark i-th row
                    matrix[0][j] = 0; // mark j-th column
                }
            }
        }

        // Set cells to zero based on markers
        // Skip first row and first column for now
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // If first row originally had zero, set entire first row to zero
        if (isFirstRowZero) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        // If first column originally had zero, set entire first column to zero
        if (isFirstColZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
