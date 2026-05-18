class Solution {

    // Maximum people allowed
    private int N;

    // Minimum profit required
    private int thresholdProfit;

    // Mod value to avoid integer overflow
    private int MOD = 1_000_000_007;

    private int solve(int i,
            int profit,
            int people,
            int[] group,
            int[] profits,
            int[][][] dp) {

        // Invalid case:
        // More people used than allowed
        if (people > N)
            return 0;

        // Base case:
        // All crimes are processed
        if (i == group.length) {

            // If required minimum profit achieved,
            // this is one valid scheme
            if (profit >= thresholdProfit) {
                return dp[i][profit][people] = 1;
            }

            // Otherwise invalid scheme
            return dp[i][profit][people] = 0;
        }

        // If already computed, return stored answer
        if (dp[i][profit][people] != -1) {
            return dp[i][profit][people];
        }

        // Option 1:
        // Skip current crime
        int notTake = solve(
                i + 1,
                profit,
                people,
                group,
                profits,
                dp) % MOD;

        // Option 2:
        // Take current crime
        //
        // Add:
        // - required group members
        // - earned profit
        //
        // Profit is capped at thresholdProfit
        // because anything above it is treated same
        int take = solve(
                i + 1,
                Math.min(profit + profits[i], thresholdProfit),
                people + group[i],
                group,
                profits,
                dp) % MOD;

        // Total valid schemes
        // = take + notTake
        return dp[i][profit][people] = ((take % MOD) + (notTake % MOD)) % MOD;
    }

    public int profitableSchemes(int n,
            int minProfit,
            int[] group,
            int[] profits) {

        // Store constraints globally
        N = n;
        thresholdProfit = minProfit;

        // DP state:
        //
        // dp[i][profit][people]
        //
        // i       -> current crime index
        // profit  -> current accumulated profit
        // people  -> current members used
        int[][][] dp = new int[101][101][101];

        // Initialize DP with -1
        for (int[][] r1 : dp) {
            for (int[] r2 : r1) {
                Arrays.fill(r2, -1);
            }
        }

        // Start recursion:
        // index = 0
        // profit = 0
        // people used = 0
        return solve(0, 0, 0, group, profits, dp);
    }
}