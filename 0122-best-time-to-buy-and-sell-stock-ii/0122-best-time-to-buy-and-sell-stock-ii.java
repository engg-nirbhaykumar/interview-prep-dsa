class Solution {
    public int maxProfit(int[] prices) {
        // This will store the total profit from multiple transactions
        int maxProfit = 0;

        // Start from day 1 since we compare with previous day
        for (int i = 1; i < prices.length; i++) {

            // If today's price is higher than yesterday's,
            // we can make profit by buying yesterday and selling today
            if (prices[i] > prices[i - 1]) {

                // Add this profit to the total
                // This effectively captures all upward trends
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }

        // Return total accumulated profit
        return maxProfit;
    }
}