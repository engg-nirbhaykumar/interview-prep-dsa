class Solution {

    // Checks whether it is possible to select 'k' candies
    // such that the minimum difference between any two selected
    // candies is at least 'mid'
    private boolean isPossible(int[] price, int k, int mid) {

        // We always pick the first (smallest) price
        int count = 1; // number of candies picked
        int lastPrice = price[0]; // last picked candy price

        // Try to greedily pick remaining candies
        for (int i = 1; i < price.length; i++) {

            // Pick current candy only if it maintains
            // minimum difference >= mid
            if (price[i] - lastPrice >= mid) {
                count++; // candy picked
                lastPrice = price[i]; // update last picked price
            }

            // If we already picked k candies, this mid is feasible
            if (count == k) {
                return true;
            }
        }

        // Could not pick k candies with this minimum difference
        return false;
    }

    public int maximumTastiness(int[] price, int k) {

        // Sort prices to apply greedy selection
        Arrays.sort(price);

        // Minimum possible tastiness
        int low = 0;

        // Maximum possible tastiness (max price - min price)
        int high = price[price.length - 1] - price[0];

        int result = 0;

        // Binary search on the answer (minimum difference)
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Check if tastiness = mid is achievable
            if (isPossible(price, k, mid)) {
                result = mid; // store valid answer
                low = mid + 1; // try to increase tastiness
            } else {
                high = mid - 1; // reduce tastiness
            }
        }

        // Maximum possible minimum difference
        return result;
    }
}
