class Solution {

    // Recursive DP function
    // i → current day
    // canBuy → 1 = can buy, 0 = holding stock
    private int solve(int i, int canBuy, int[] prices, int fee, Integer[][] dp) {

        // Base case: no more days → no profit
        if (i == prices.length)
            return 0;

        // Return cached result if already computed
        if (dp[i][canBuy] != null)
            return dp[i][canBuy];

        int profit;

        if (canBuy == 1) {
            // Option 1: Buy stock today
            int buy = -prices[i] + solve(i + 1, 0, prices, fee, dp);

            // Option 2: Skip buying
            int skip = solve(i + 1, 1, prices, fee, dp);

            profit = Math.max(buy, skip);

        } else {
            // Option 1: Sell stock today (pay transaction fee)
            int sell = prices[i] - fee + solve(i + 1, 1, prices, fee, dp);

            // Option 2: Skip selling
            int skip = solve(i + 1, 0, prices, fee, dp);

            profit = Math.max(sell, skip);
        }

        return dp[i][canBuy] = profit;
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        // dp[day][canBuy]
        Integer[][] dp = new Integer[n][2];

        return solve(0, 1, prices, fee, dp);
    }
}