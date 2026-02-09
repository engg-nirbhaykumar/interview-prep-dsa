class Solution {
    public long subArrayRanges(int[] nums) {

        // Sum of all subarray maximums
        long maxSum = computeExtremeSum(nums, true);

        // Sum of all subarray minimums
        long minSum = computeExtremeSum(nums, false);

        // Range = max - min for each subarray
        return maxSum - minSum;
    }

    // This function computes:
    // Σ nums[i] * (# subarrays where nums[i] is extreme)
    // extreme = max if isMax = true, else min
    private long computeExtremeSum(int[] nums, boolean isMax) {

        int n = nums.length;

        // pse[i] = number of choices to extend subarray to LEFT
        // nse[i] = number of choices to extend subarray to RIGHT
        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        // ------------------ PREVIOUS EXTREME (LEFT DISTANCE) ------------------
        for (int i = 0; i < n; i++) {

            // For MAX: pop smaller elements (they can't be max anymore)
            // For MIN: pop larger elements (they can't be min anymore)
            while (!st.isEmpty() &&
                   (isMax ? nums[st.peek()] < nums[i] : nums[st.peek()] > nums[i])) {
                st.pop();
            }

            // If no blocking extreme on left → extend to index 0
            // Else → extend till index after previous extreme
            pse[i] = st.isEmpty() ? i + 1 : i - st.peek();

            st.push(i);
        }

        st.clear();  // Important: reset stack for right pass

        // ------------------ NEXT EXTREME (RIGHT DISTANCE) ------------------
        for (int i = n - 1; i >= 0; i--) {

            // Strict/non-strict logic handles duplicates correctly
            // MAX: pop smaller OR equal (next must be strictly greater)
            // MIN: pop greater OR equal (next must be strictly smaller)
            while (!st.isEmpty() &&
                   (isMax ? nums[st.peek()] <= nums[i] : nums[st.peek()] >= nums[i])) {
                st.pop();
            }

            // If no blocking extreme on right → extend to end
            // Else → extend till index before next extreme
            nse[i] = st.isEmpty() ? n - i : st.peek() - i;

            st.push(i);
        }

        // ------------------ CONTRIBUTION CALCULATION ------------------
        long result = 0;

        for (int i = 0; i < n; i++) {

            // Total subarrays where nums[i] is the extreme
            long contributionCount = (long) pse[i] * nse[i];

            // Each such subarray contributes nums[i]
            result += nums[i] * contributionCount;
        }

        return result;
    }
}
