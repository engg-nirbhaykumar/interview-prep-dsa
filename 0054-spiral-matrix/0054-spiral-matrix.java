class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        // Edge case: empty matrix
        if (matrix == null || n == 0)
            return result;

        // Define the boundaries of the current spiral layer
        int top = 0; // Topmost row not yet traversed
        int bottom = n - 1; // Bottommost row not yet traversed
        int left = 0; // Leftmost column not yet traversed
        int right = m - 1; // Rightmost column not yet traversed

        // Continue while boundaries are valid
        while (top <= bottom && left <= right) {

            // Traverse from left → right on the top row
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++; // Move the top boundary down

            // Traverse from top → bottom on the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // Traverse from right → left on the bottom row (only if valid)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--; // Move the bottom boundary up
            }

            // Traverse from bottom → top on the left column (only if valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }

        return result;
    }
}
