class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length; // Total number of elements in the array

        int[] dp = new int[n];
        // dp[i] will store the length of the longest increasing subsequence
        // that ENDS at index i

        Arrays.fill(dp, 1);
        // Initialize all values to 1 because:
        // every single element by itself is a subsequence of length 1

        int maxLen = 1;
        // This will store the overall maximum LIS length found so far

        for (int i = 1; i < n; i++) {
            // Start from index 1 because dp[0] is already correctly set to 1

            for (int j = 0; j < i; j++) {
                // Check all elements before index i

                if (nums[j] < nums[i]) {
                    // If current element nums[i] can extend the subsequence ending at j
                    // (i.e., maintain increasing order)

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // Update dp[i] by choosing the best possible extension:
                    // either keep current value OR extend subsequence from j
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
            // Update global maximum LIS length after processing index i
        }
        
        return maxLen; // Final answer: longest increasing subsequence length
    }
}