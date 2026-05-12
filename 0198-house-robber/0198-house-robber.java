class Solution {

    // Recursive function with memoization
    // i -> current index
    // n -> length of array (exclusive upper bound)
    // dp[i] -> maximum money that can be robbed starting from index i
    private int solve(int[] nums, int i, int n, int[] dp) {

        // Base case:
        // If index goes beyond last house, no money can be robbed
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

        // DP array where dp[i] stores answer for subproblem starting at index i
        int[] dp = new int[n];

        // Initialize with -1 to mark uncomputed states
        Arrays.fill(dp, -1);

        // Start recursion from index 0
        return solve(nums, 0, n, dp);
    }
}