class Solution {

    // Recursive DP function
    // day → current index in prices array
    // canBuy → 1 means we can buy, 0 means we are holding stock (so we can sell)
    // transactionLeft → how many transactions (buy+sell pairs) we can still perform
    // dp → memoization table to store already computed states
    private int solve(int day, int canBuy, int transactionLeft, int[] prices, Integer[][][] dp) {

        // Base case:
        // If we've reached the end OR no transactions are left → no profit possible
        if (day == prices.length || transactionLeft == 0)
            return 0;

        // If this state is already computed, return stored result
        if (dp[day][canBuy][transactionLeft] != null)
            return dp[day][canBuy][transactionLeft];

        int profit = 0;

        // Case 1: We are allowed to BUY
        if (canBuy == 1) {

            // Option 1: Buy stock today → subtract price, move to "cannot buy" state
            int buy = -prices[day] + solve(day + 1, 0, transactionLeft, prices, dp);

            // Option 2: Skip buying today
            int skip = solve(day + 1, 1, transactionLeft, prices, dp);

            // Take the better of the two choices
            profit = Math.max(buy, skip);

        } else { // Case 2: We are holding stock → we can SELL

            // Option 1: Sell stock today → add price, reduce transaction count
            int sell = prices[day] + solve(day + 1, 1, transactionLeft - 1, prices, dp);

            // Option 2: Skip selling today
            int skip = solve(day + 1, 0, transactionLeft, prices, dp);

            // Take the better of the two choices
            profit = Math.max(sell, skip);
        }

        // Store result in DP table and return
        return dp[day][canBuy][transactionLeft] = profit;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // DP table dimensions:
        // n → days
        // 2 → canBuy state (0 or 1)
        // 3 → transactionsLeft (0, 1, 2)
        Integer[][][] dp = new Integer[n][2][3];

        // Start from day 0, canBuy = 1, with 2 transactions allowed
        return solve(0, 1, 2, prices, dp);
    }
}