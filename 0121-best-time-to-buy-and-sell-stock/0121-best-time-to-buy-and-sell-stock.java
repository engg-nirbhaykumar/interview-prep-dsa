class Solution {
    public int maxProfit(int[] prices) {
        // Track the minimum price seen so far (best day to buy)
        int minPrice = Integer.MAX_VALUE;

        // Track the maximum profit achievable
        int maxProfit = 0;

        // Iterate through each day's price
        for (int price : prices) {

            // If current price is lower than any we've seen,
            // update minPrice (better buying opportunity)
            if (price < minPrice) {
                minPrice = price;
            } else {
                // Otherwise, calculate profit if we sell today
                int profit = price - minPrice;

                // Update max profit if this is the best so far
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        // Return the best profit found (0 if no profit possible)
        return maxProfit;
    }
}