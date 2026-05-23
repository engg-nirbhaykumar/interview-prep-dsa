class Solution {
    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;

        // If array size is 1 or 2,
        // the whole array itself forms an arithmetic sequence
        if (n <= 2)
            return n;

        /*
         * dp[i][diff] =
         * Length of longest arithmetic subsequence
         * ending at index i with common difference = diff - 500
         *
         * Why +500?
         * Because difference can be negative.
         * Range of nums[i] is [0,500],
         * so diff range becomes [-500,500].
         * We shift it by +500 to store safely in array index.
         */
        int[][] dp = new int[n][1001];

        // Every element alone forms arithmetic sequence of length 1
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }

        int maxLen = 1;

        // Pick current ending index
        for (int i = 1; i < n; i++) {

            // Try all previous elements
            for (int j = 0; j < i; j++) {

                // Calculate shifted difference
                int diff = nums[j] - nums[i] + 500;

                /*
                 * If extending sequence ending at j
                 * gives better result for index i,
                 * update dp[i][diff]
                 */
                if (dp[j][diff] + 1 > dp[i][diff]) {

                    // Extend arithmetic subsequence
                    dp[i][diff] = dp[j][diff] + 1;

                    // Update overall maximum length
                    maxLen = Math.max(maxLen, dp[i][diff]);
                }
            }
        }

        return maxLen;
    }
}