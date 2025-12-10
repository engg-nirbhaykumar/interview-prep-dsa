class Solution {
    public int maxProfit(int[] prices) {

        // maxProfit will store the maximum difference (sell - buy)
        // Initialize to 0 because minimum valid profit is 0 (no transaction)
        int maxProfit = 0;

        // minPrice keeps track of the smallest price seen so far
        int minPrice = Integer.MAX_VALUE;

        // Iterate through each day's price
        for (int price : prices) {

            // If current price is smaller than the smallest seen so far,
            // update minPrice to this new lowest value (best day to buy)
            if (price < minPrice) {
                minPrice = price;
            } else {

                // Otherwise, calculate profit by selling today (price - minPrice)
                int profit = price - minPrice;

                // Update maxProfit if today's profit is better
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        // Return the maximum profit we can make from one buy-sell transaction
        return maxProfit;
    }
}
