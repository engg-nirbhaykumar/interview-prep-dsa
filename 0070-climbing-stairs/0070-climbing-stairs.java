class Solution {

    // Recursive function with memoization to count ways to reach step i
    private int solve(int i, int[] dp) {

        // If step becomes negative, no valid way
        if (i < 0)
            return 0;

        // If reached step 0, one valid way found
        if (i == 0)
            return 1;

        // If already computed, return stored result
        if (dp[i] != -1)
            return dp[i];

        // Count ways by taking 1 step
        int oneStep = solve(i - 1, dp);

        // Count ways by taking 2 steps
        int twoStep = solve(i - 2, dp);

        // Store and return total ways
        return dp[i] = oneStep + twoStep;
    }

    public int climbStairs(int n) {

        // DP array to store answers for each step
        int[] dp = new int[n + 1];

        // Initialize with -1 (not calculated yet)
        Arrays.fill(dp, -1);

        // Find total ways to reach nth step
        return solve(n, dp);
    }
}