class Solution {
    public int findLongestChain(int[][] pairs) {

        int n = pairs.length;
        // Total number of pairs

        int[] dp = new int[n];
        // dp[i] = longest chain length ending at index i

        Arrays.fill(dp, 1);
        // Every pair alone can form a chain of length 1

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        // Sort pairs based on ending value (second element)
        // Helps process smaller ending pairs first

        int maxLen = 1;
        // Stores overall maximum chain length found so far

        for (int i = 1; i < n; i++) {
            // Try to build chain ending at pair i

            for (int j = 0; j < i; j++) {
                // Check all previous pairs

                if (pairs[j][1] < pairs[i][0]) {
                    // If end of previous pair is smaller than
                    // start of current pair,
                    // then current pair can be added after previous pair

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // Extend the best chain ending at j
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
            // Update overall answer after processing i
        }

        return maxLen;
        // Return longest possible chain
    }
}