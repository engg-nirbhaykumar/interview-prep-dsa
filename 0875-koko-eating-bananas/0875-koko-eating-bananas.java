class Solution {

    // Utility function to get the maximum pile size (upper bound of eating speed)
    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    // Check if Koko can finish eating all bananas within h hours if she eats at speed k per hour
    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;

        for (int pile : piles) {
            // Calculate hours needed for each pile at speed k
            // Equivalent to ceil(pile / k)
            hours += (pile + k - 1) / k;

            // Optimization: if already exceeding required hours, return false
            if (hours > h)
                return false;
        }
        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        // Binary search between 1 banana/hr and max pile size bananas/hr
        int low = 1;
        int high = getMax(piles);

        // Binary search to find minimum valid speed
        while (low < high) {
            int mid = low + (high - low) / 2;

            // If she can finish with speed mid, try slower speed on left side
            if (canFinish(piles, h, mid)) {
                high = mid;
            }
            // Else, speed must be increased (search right side)
            else {
                low = mid + 1;
            }
        }

        // low == high holds the minimum eating speed required
        return low;
    }
}
