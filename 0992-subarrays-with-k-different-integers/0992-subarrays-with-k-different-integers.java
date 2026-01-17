class Solution {

    /*
     * Returns the number of subarrays with AT MOST k distinct elements
     * Uses variable-size sliding window
     */
    private int slidingWindow(int[] nums, int k) {
        // Map to store frequency of elements in the current window
        HashMap<Integer, Integer> cMap = new HashMap<>();

        int left = 0;     // Left pointer of sliding window
        int result = 0;   // Stores count of valid subarrays

        // Right pointer expands the window
        for (int right = 0; right < nums.length; right++) {

            // Add current element to the window
            cMap.put(nums[right], cMap.getOrDefault(nums[right], 0) + 1);

            /*
             * If number of distinct elements exceeds k,
             * shrink the window from the left
             */
            while (cMap.size() > k) {
                cMap.put(nums[left], cMap.get(nums[left]) - 1);

                // Remove element completely if frequency becomes zero
                if (cMap.get(nums[left]) == 0) {
                    cMap.remove(nums[left]);
                }

                left++; // Shrink window
            }

            /*
             * Number of valid subarrays ending at index 'right'
             * = window size = (right - left + 1)
             */
            result += right - left + 1;
        }

        return result;
    }

    /*
     * Returns number of subarrays with EXACTLY k distinct elements
     *
     * Key Idea:
     * Exactly K = At Most K - At Most (K - 1)
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
    }
}
