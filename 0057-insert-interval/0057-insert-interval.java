class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int i = 0;

        // List to store final merged intervals
        List<int[]> result = new ArrayList<>();

        // Step 1: Add all intervals that end BEFORE newInterval starts
        // These intervals do not overlap
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge all overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {

            // Expand newInterval to include overlapping interval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged interval
        result.add(newInterval);

        // Step 3: Add remaining intervals that start AFTER newInterval ends
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert list to array and return
        return result.toArray(new int[result.size()][]);
    }
}