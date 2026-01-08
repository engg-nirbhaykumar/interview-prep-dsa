class Solution {

    // Finds the maximum weight in the array
    // This is the minimum possible ship capacity
    private int getMax(int[] weights) {
        int max = 0;
        for (int w : weights) {
            max = Math.max(max, w);
        }
        return max;
    }

    // Finds the sum of all weights
    // This is the maximum possible ship capacity
    private int getSum(int[] weights) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        return sum;
    }

    // Checks if we can ship all packages within 'days'
    // using ship capacity = mid
    private boolean isPossible(int[] weights, int days, int mid) {

        int currentLoad = 0;   // Current ship load for the day
        int requireDays = 1;   // At least one day is needed

        for (int w : weights) {

            // If adding current package exceeds ship capacity,
            // we need to use a new day
            if (currentLoad + w > mid) {
                requireDays++;        // Move to next day
                currentLoad = w;      // Start new day with current package
            } else {
                currentLoad += w;     // Add package to current day
            }
        }

        // Check if required days are within allowed days
        return requireDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {

        // Minimum capacity must be at least the max weight
        int low = getMax(weights);

        // Maximum capacity is sum of all weights
        int high = getSum(weights);

        int result = high;

        // Binary search on ship capacity
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // If shipping is possible with this capacity
            if (isPossible(weights, days, mid)) {
                result = mid;      // Store valid answer
                high = mid - 1;    // Try to minimize capacity
            } else {
                low = mid + 1;     // Increase capacity
            }
        }

        return result;
    }
}
