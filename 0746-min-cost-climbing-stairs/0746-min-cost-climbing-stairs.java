class Solution {

    // Recursive function with memoization
    // Returns minimum cost required to reach top starting from index i
    private int solve(int i, int n, int[] dp, int[] cost) {

        // If reached or crossed top, no more cost needed
        if (i >= n)
            return 0;

        // If already computed, return stored result
        if (dp[i] != -1)
            return dp[i];

        // Take 1 step from current stair
        int oneStep = cost[i] + solve(i + 1, n, dp, cost);

        // Take 2 steps from current stair
        int twoStep = cost[i] + solve(i + 2, n, dp, cost);

        // Store minimum of both choices
        return dp[i] = Math.min(oneStep, twoStep);
    }

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        // DP array to store minimum cost from each index
        int[] dp = new int[n + 1];

        // Initialize with -1 (not computed yet)
        Arrays.fill(dp, -1);

        // We can start from step 0 or step 1
        // Return minimum of both starting points
        return Math.min(solve(0, n, dp, cost), solve(1, n, dp, cost));
    }
}