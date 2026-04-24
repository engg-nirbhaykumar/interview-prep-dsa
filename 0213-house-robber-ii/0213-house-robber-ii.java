class Solution {

    // Recursive function with memoization
    // i -> current index
    // n -> exclusive upper bound (we consider houses in range [i, n-1])
    // dp[i] -> maximum money that can be robbed starting from index i
    private int solve(int[] nums, int i, int n, int[] dp) {

        // Base case: if index goes beyond allowed range, no money can be robbed
        if (i >= n)
            return 0;

        // Return already computed result to avoid recomputation
        if (dp[i] != -1)
            return dp[i];

        // Option 1: Rob current house and skip next house
        int take = nums[i] + solve(nums, i + 2, n, dp);

        // Option 2: Skip current house and move to next
        int notTake = solve(nums, i + 1, n, dp);

        // Store and return the maximum of both choices
        return dp[i] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        // Edge case: if only one house, rob it
        if (n == 1)
            return nums[0];

        // Case 1: Consider houses from index 0 to n-2 (exclude last house)
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        // Case 2: Consider houses from index 1 to n-1 (exclude first house)
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        // Take maximum of both independent cases
        return Math.max(
            solve(nums, 0, n - 1, dp1), // include first, exclude last
            solve(nums, 1, n, dp2)      // exclude first, include last
        );
    }
}