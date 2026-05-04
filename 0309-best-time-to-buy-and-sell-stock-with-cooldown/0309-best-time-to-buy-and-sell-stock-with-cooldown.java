class Solution {

    // Recursive DP function
    // day → current index in prices array
    // canBuy → 1 = we are allowed to buy, 0 = we are holding stock (so we can sell)
    // dp → memoization table storing results for (day, canBuy)
    private int solve(int day, int canBuy, int[] prices, Integer[][] dp) {

        // Base case:
        // If we've gone past the last day → no profit possible
        if (day >= prices.length)
            return 0;

        // Return cached result if already computed
        if (dp[day][canBuy] != null)
            return dp[day][canBuy];

        int profit = 0;

        // Case 1: We are allowed to BUY
        if (canBuy == 1) {

            // Option 1: Buy today
            // Pay price → move to "holding stock" state (canBuy = 0)
            int buy = -prices[day] + solve(day + 1, 0, prices, dp);

            // Option 2: Skip buying today
            int skip = solve(day + 1, 1, prices, dp);

            // Choose the better option
            profit = Math.max(buy, skip);

        } else {
            // Case 2: We are holding stock → we can SELL

            // Option 1: Sell today
            // Gain price → BUT due to cooldown, skip next day
            // So we move to day + 2 and canBuy = 1
            int sell = prices[day] + solve(day + 2, 1, prices, dp);

            // Option 2: Skip selling today (continue holding)
            int skip = solve(day + 1, 0, prices, dp);

            // Choose the better option
            profit = Math.max(sell, skip);
        }

        // Store result in DP table and return
        return dp[day][canBuy] = profit;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // DP table:
        // dp[day][canBuy]
        // day → 0 to n-1
        // canBuy → 0 or 1
        Integer[][] dp = new Integer[n][2];

        // Start from day 0, with permission to buy
        return solve(0, 1, prices, dp);
    }
}