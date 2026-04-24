class Solution {

    // Recursive function with memoization
    private int solve(int n, int[] dp) {

        // If steps go negative, this is not a valid way
        if (n < 0)
            return 0;

        // If we reach exactly step 0, we found one valid way
        if (n == 0)
            return 1;

        // Return the already computed result to avoid recomputation
        if (dp[n] != -1) 
            return dp[n];

        // Compute number of ways by taking 1 step
        int oneStep = solve(n - 1, dp);

        // Compute number of ways by taking 2 steps
        int twoStep = solve(n - 2, dp);

        // Store result in dp array and return
        return dp[n] = oneStep + twoStep;
    }

    public int climbStairs(int n) {

        // DP array to store results of subproblems
        int[] dp = new int[n + 1];

        // Initialize dp array with -1 to indicate uncomputed states
        Arrays.fill(dp, -1);

        // Start solving from step n
        return solve(n, dp);
    }
}