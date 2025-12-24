class Solution {

    public int[] searchRange(int[] nums, int target) {

        // Find the first occurrence of target
        int first = findBound(nums, target, true);

        // Find the last occurrence of target
        int last = findBound(nums, target, false);

        // Return the range [firstIndex, lastIndex]
        return new int[] { first, last };
    }

    /**
     * Binary search helper to find either:
     * - first occurrence (isFirst = true)
     * - last occurrence  (isFirst = false)
     */
    private int findBound(int[] nums, int target, boolean isFirst) {

        int bound = -1; // Stores the answer index
        int low = 0; // Start pointer
        int high = nums.length - 1; // End pointer

        // Standard binary search loop
        while (low <= high) {

            // Safe mid calculation
            int mid = low + (high - low) / 2;

            // If target is found at mid
            if (nums[mid] == target) {
                bound = mid; // Update the potential answer

                // If searching for first occurrence,
                // move left to find earlier index
                if (isFirst) {
                    high = mid - 1;
                }
                // If searching for last occurrence,
                // move right to find later index
                else {
                    low = mid + 1;
                }
            }
            // If target is larger, search right half
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            // If target is smaller, search left half
            else {
                high = mid - 1;
            }
        }

        // Returns index of first/last occurrence, or -1 if not found
        return bound;
    }
}
