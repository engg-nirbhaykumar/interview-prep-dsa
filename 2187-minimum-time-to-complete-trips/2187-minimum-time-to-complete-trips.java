class Solution {

    // Checks whether we can complete at least 'totalTrips'
    // within 'mid' units of time
    private boolean isPossible(int[] time, int totalTrips, long mid) {

        long trips = 0;  // total trips completed by all buses

        // Each bus works independently
        for (int t : time) {

            // Number of trips this bus can complete in 'mid' time
            trips += mid / t;

            // Early exit if we already reached required trips
            if (trips >= totalTrips) {
                return true;
            }
        }

        // Check if total trips meet the requirement
        return trips >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {

        // Find the fastest bus time
        // This helps in setting the upper bound for binary search
        long minTime = Long.MAX_VALUE;
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        // Minimum possible time is 1
        long low = 1;

        // Maximum possible time:
        // if only the fastest bus runs all trips
        long high = minTime * totalTrips;

        long result = high;

        // Binary search on time
        while (low <= high) {

            // Candidate time
            long mid = low + (high - low) / 2;

            // Check if 'mid' time is sufficient
            if (isPossible(time, totalTrips, mid)) {
                result = mid;      // valid answer found
                high = mid - 1;    // try to minimize time
            } else {
                low = mid + 1;     // need more time
            }
        }

        // Minimum time needed to complete all trips
        return result;
    }
}
