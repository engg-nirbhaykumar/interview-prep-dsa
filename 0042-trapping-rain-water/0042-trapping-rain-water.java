class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // lMax[i] = maximum height from index 0 → i (left side max)
        int[] lMax = new int[n];

        // rMax[i] = maximum height from index i → n-1 (right side max)
        int[] rMax = new int[n];

        // First bar’s left max is itself
        lMax[0] = height[0];

        // Build left max array
        // At every index, store the highest bar seen so far from the left
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }

        // Last bar’s right max is itself
        rMax[n - 1] = height[n - 1];

        // Build right max array
        // At every index, store the highest bar seen so far from the right
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        int total = 0; // total trapped water

        // Water trapped at index i =
        // min(left max, right max) - height[i]
        for (int i = 0; i < n; i++) {
            total += (Math.min(lMax[i], rMax[i]) - height[i]);
        }

        return total;
    }
}
