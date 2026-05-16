class Solution {

    private int solve(int i, int rem, int[] nums, int[][] dp) {

        // Base case:
        // If all elements are processed
        if (i >= nums.length) {

            // If remainder is 0,
            // current subset sum is divisible by 3
            if (rem == 0)
                return 0;

            // Invalid case:
            // subset sum not divisible by 3
            return Integer.MIN_VALUE;
        }

        // If already computed, return stored answer
        if (dp[i][rem] != -1)
            return dp[i][rem];

        // Option 1: Take current element
        //
        // New remainder after adding nums[i]:
        // (current remainder + nums[i]) % 3
        //
        // Add nums[i] to final answer
        int take = nums[i]
                + solve(i + 1, (rem + nums[i]) % 3, nums, dp);

        // Option 2: Skip current element
        int notTake = solve(i + 1, rem, nums, dp);

        // Store and return maximum possible sum
        return dp[i][rem] = Math.max(take, notTake);
    }

    public int maxSumDivThree(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n][3];
        // dp[i][rem] stores:
        // maximum sum possible starting from index i
        // with current remainder = rem

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start from index 0 with remainder 0
        return solve(0, 0, nums, dp);
    }
}