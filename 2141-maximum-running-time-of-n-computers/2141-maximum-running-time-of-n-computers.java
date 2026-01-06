class Solution {

    // Checks if all 'n' computers can run for 'mid' minutes
    private boolean isPossible(int n, int[] batteries, long mid) {

        // Total power required to run n computers for 'mid' time
        long target = n * mid;

        // Total power we can actually supply
        long actual = 0;

        // Each battery can contribute at most 'mid' units
        // (extra power beyond mid is useless for a single computer)
        for (int b : batteries) {
            actual += Math.min(b, mid);
        }

        // If supplied power is enough, this runtime is possible
        return actual >= target;
    }

    public long maxRunTime(int n, int[] batteries) {

        long totalSum = 0;

        // Compute total battery capacity
        for (int b : batteries) {
            totalSum += b;
        }

        // Minimum runtime can be 0
        long low = 0;

        // Maximum possible runtime is total power divided equally among n computers
        long high = totalSum / n;

        long result = 0;

        // Binary search on maximum runtime
        while (low <= high) {
            long mid = low + (high - low) / 2;

            // Check if runtime = mid is achievable
            if (isPossible(n, batteries, mid)) {
                result = mid; // store valid answer
                low = mid + 1; // try for larger runtime
            } else {
                high = mid - 1; // reduce runtime
            }
        }

        return result;
    }
}
