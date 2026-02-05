class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;

        // Step 1: Sort intervals by their ending time
        // Choosing intervals that end earlier leaves more room for others
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // lastEnd = end time of the last interval we decided to keep
        int lastEnd = intervals[0][1];

        // count = number of non-overlapping intervals we can keep
        int count = 1; // first interval is always selected

        // Step 2: Greedily select intervals
        for (int i = 1; i < n; i++) {

            // If current interval starts AFTER or AT lastEnd,
            // it does not overlap → we can keep it
            if (lastEnd <= intervals[i][0]) {
                count++;
                lastEnd = intervals[i][1]; // update the boundary
            }
            // Else → overlapping interval, so we skip (remove) it
        }

        // Total intervals to remove = total - intervals we kept
        return n - count;
    }
}
