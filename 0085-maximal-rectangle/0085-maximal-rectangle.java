class Solution {

    public int maximalRectangle(char[][] matrix) {

        // Edge case: empty matrix
        if (matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // This array represents the histogram heights for current row
        int[] heights = new int[cols];

        int maxArea = 0;

        // Traverse each row — treating each row as base of histogram
        for (int i = 0; i < rows; i++) {

            // Update histogram heights
            for (int j = 0; j < cols; j++) {

                // If we see '1', extend the column height
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                }
                // If '0', column is broken — reset height
                else {
                    heights[j] = 0;
                }
            }

            // For this histogram, compute largest rectangle
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    // Standard Largest Rectangle in Histogram using Monotonic Stack
    private int largestRectangleArea(int[] heights) {

        int n = heights.length;

        // Previous Smaller Element index
        int[] pse = new int[n];

        // Next Smaller Element index
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        // ------------------ LEFT BOUNDARY (Previous Smaller Element) ------------------
        for (int i = 0; i < n; i++) {

            // Maintain increasing stack
            // Remove all bars taller than current
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }

            // If empty → no smaller on left
            // Else → top of stack is previous smaller
            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear(); // reuse stack

        // ------------------ RIGHT BOUNDARY (Next Smaller Element) ------------------
        for (int i = n - 1; i >= 0; i--) {

            // Pop bars taller OR equal
            // '=' ensures each rectangle counted once
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            // If empty → no smaller on right
            // Else → top is next smaller
            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        // ------------------ AREA CALCULATION ------------------
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // Width = distance between boundaries
            int width = nse[i] - pse[i] - 1;

            // Rectangle area where heights[i] is smallest bar
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
