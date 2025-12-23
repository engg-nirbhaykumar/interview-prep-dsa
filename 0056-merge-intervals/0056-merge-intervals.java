class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        // If there is only one interval, no merge is needed
        if (n == 1) {
            return intervals;
        }

        // Sort intervals based on start time
        // This ensures overlapping intervals are adjacent
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // List to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Add the first interval as the initial merged interval
        result.add(intervals[0]);

        // Iterate through remaining intervals
        for (int i = 1; i < n; i++) {

            // Last interval in the merged result
            int[] last = result.get(result.size() - 1);

            // Current interval being processed
            int[] current = intervals[i];

            // Check if current interval overlaps with the last merged interval
            if (last[1] >= current[0]) {
                // Merge by extending the end of the last interval
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap → add current interval to result
                result.add(current);
            }
        }

        // Convert List to 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}
