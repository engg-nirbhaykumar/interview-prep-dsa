class Solution {

    // Utility function to get the maximum bloom day from the array
    // We search days between 1 ... max(bloomDay)
    private int getMax(int[] bloomDay) {
        int max = 0;
        for (int day : bloomDay) {
            max = Math.max(max, day);
        }
        return max;
    }

    // Check if we can make at least m bouquets by day = mid
    // Requirement: To make 1 bouquet, we need k *adjacent* flowers that all bloomed on or before mid
    private boolean canMakeMBouquets(int[] bloomDay, int m, int k, int mid) {
        int bouqCount = 0; // Number of bouquets formed
        int consecutiveCount = 0;// Count of consecutive flowers ready to use

        for (int i = 0; i < bloomDay.length; i++) {
            // Flower is bloomed and usable
            if (bloomDay[i] <= mid) {
                consecutiveCount++; // Continue streak
            } else {
                consecutiveCount = 0; // Reset because streak is broken
            }

            // When streak reaches k → we can form a bouquet
            if (consecutiveCount == k) {
                bouqCount++; // Bouquet formed
                consecutiveCount = 0; // Reset streak for next bouquet
            }
        }

        // Return true if we can make at least m bouquets
        return bouqCount >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        // Edge case: Not enough flowers in garden → impossible
        if (bloomDay.length < m * k) {
            return -1;
        }

        int low = 0; // Lowest possible day to check
        int high = getMax(bloomDay); // Highest day (max bloom day)
        int result = -1; // Store potential answer (minimum valid day)

        // Binary search on the number of days
        while (low <= high) {
            int mid = low + (high - low) / 2; // Candidate day

            // If it IS possible to make m bouquets by day mid
            if (canMakeMBouquets(bloomDay, m, k, mid)) {
                result = mid; // Store answer
                high = mid - 1; // Try to find smaller (min possible) day
            }
            // If NOT possible → increase days and try again
            else {
                low = mid + 1;
            }
        }

        return result;
    }
}
