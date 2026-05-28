class Solution {

    // Total number of jobs
    private int n;

    // dp[i] = maximum profit we can earn starting from index i
    private int[] dp;

    /**
     * Recursive DP function
     * Returns maximum profit starting from job index i
     */
    private int solve(int[][] jobs, int i) {

        // Base case:
        // If we reach beyond last job, no profit can be earned
        if (i >= n)
            return 0;

        // If already computed, return memoized answer
        if (dp[i] != -1)
            return dp[i];

        // Find next non-overlapping job using binary search
        int nextJob = getNextJobIndexBS(jobs, i + 1, jobs[i][1]);

        // Option 1:
        // Take current job profit + solve for next compatible job
        int take = jobs[i][2] + solve(jobs, nextJob);

        // Option 2:
        // Skip current job and move to next index
        int notTake = solve(jobs, i + 1);

        // Store and return maximum profit
        return dp[i] = Math.max(take, notTake);
    }

    /**
     * Binary Search:
     * Finds first job whose start time >= current job's end time
     */
    private int getNextJobIndexBS(int[][] jobs, int low, int end) {

        int high = n - 1;

        // Default result = n
        // Means no valid next job exists
        int result = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Valid next non-overlapping job found
            if (jobs[mid][0] >= end) {

                // Store candidate answer
                result = mid;

                // Try finding even earlier valid job
                high = mid - 1;
            } else {

                // Need larger start time
                low = mid + 1;
            }
        }

        return result;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        // Total jobs
        n = startTime.length;

        // Initialize memoization array
        dp = new int[n];

        Arrays.fill(dp, -1);

        // jobs[i] = {startTime, endTime, profit}
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // Sort jobs based on start time
        // Required for binary search
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        // Start recursion from first job
        return solve(jobs, 0);
    }
}