class Solution {
    public int longestOnes(int[] nums, int k) {

        // Left pointer of the sliding window
        int i = 0;

        // Counts number of zeros in the current window
        int zeroCount = 0;

        // Stores the maximum window size found
        int maxLength = 0;

        // Right pointer expands the sliding window
        for (int j = 0; j < nums.length; j++) {

            // If current element is zero, include it in zero count
            if (nums[j] == 0) {
                zeroCount++;
            }

            // If number of zeros exceeds k, shrink the window from the left
            while (zeroCount > k) {
                // If the element leaving the window is zero, decrement zero count
                if (nums[i] == 0) {
                    zeroCount--;
                }
                // Move left pointer forward
                i++;
            }

            // Update the maximum valid window length
            maxLength = Math.max(maxLength, j - i + 1);
        }

        // Return the length of the longest subarray with at most k zeros
        return maxLength;
    }
}
