class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        // pse[i] = index of Previous Smaller Element
        // nse[i] = index of Next Smaller Element
        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        // ------------------ PREVIOUS SMALLER ELEMENT (LEFT BOUNDARY) ------------------
        for (int i = 0; i < n; i++) {

            // Maintain a monotonic increasing stack
            // Pop bars that are taller than current — they can't be left boundary
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }

            // If stack empty → no smaller element on left
            // Else → top is the previous smaller element
            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i); // Push current index
        }

        st.clear(); // Reset stack for right pass

        // ------------------ NEXT SMALLER ELEMENT (RIGHT BOUNDARY) ------------------
        for (int i = n - 1; i >= 0; i--) {

            // Pop all bars taller OR equal to current
            // Equal handled here to avoid double counting width
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            // If empty → no smaller element on right
            // Else → top is next smaller element
            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        // ------------------ AREA CALCULATION ------------------
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // Width = distance between next smaller and previous smaller
            int width = nse[i] - pse[i] - 1;

            // Area with heights[i] as the smallest bar in that width
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
