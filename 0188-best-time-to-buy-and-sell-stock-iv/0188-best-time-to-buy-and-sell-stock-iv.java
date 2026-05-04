class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // DP table:
        // dp[i][canBuy][transactionsLeft]
        // i → current day (0 to n-1)
        // canBuy → 1 = we can buy, 0 = we are holding stock (so we can sell)
        // transactionsLeft → how many transactions (buy + sell pairs) we can still perform
        Integer[][][] dp = new Integer[n][2][k + 1];

        // Start from day 0, allowed to buy, with k transactions
        return solve(0, 1, k, prices, dp);
    }

    private int solve(int i, int canBuy, int transactionsLeft, int[] prices, Integer[][][] dp) {

        // Base case:
        // If we've processed all days OR no transactions remain → no profit possible
        if (i == prices.length || transactionsLeft == 0)
            return 0;

        // Return cached result if already computed
        if (dp[i][canBuy][transactionsLeft] != null)
            return dp[i][canBuy][transactionsLeft];

        int profit = 0;

        // Case 1: We are allowed to BUY
        if (canBuy == 1) {

            // Option 1: Buy today
            // Pay price → move to "holding stock" state (canBuy = 0)
            int buy = -prices[i] + solve(i + 1, 0, transactionsLeft, prices, dp);

            // Option 2: Skip buying today
            int skip = solve(i + 1, 1, transactionsLeft, prices, dp);

            // Choose the better option
            profit = Math.max(buy, skip);

        } else {
            // Case 2: We are holding stock → we can SELL

            // Option 1: Sell today
            // Gain price → move to "can buy" state
            // Reduce transactionsLeft because one full transaction is completed
            int sell = prices[i] + solve(i + 1, 1, transactionsLeft - 1, prices, dp);

            // Option 2: Skip selling today
            int skip = solve(i + 1, 0, transactionsLeft, prices, dp);

            // Choose the better option
            profit = Math.max(sell, skip);
        }

        // Store result in DP table and return
        return dp[i][canBuy][transactionsLeft] = profit;
    }
}