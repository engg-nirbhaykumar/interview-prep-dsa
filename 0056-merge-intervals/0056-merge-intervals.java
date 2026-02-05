class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        // If only one interval, nothing to merge
        if (n == 1)
            return intervals;

        // Step 1: Sort intervals by starting time
        // This ensures overlapping intervals come next to each other
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Add the first interval as starting point
        result.add(intervals[0]);

        // Step 2: Traverse and merge
        for (int i = 1; i < n; i++) {

            int[] last = result.get(result.size() - 1); // last merged interval
            int[] current = intervals[i]; // current interval

            // If intervals overlap (current starts before last ends)
            if (last[1] >= current[0]) {
                // Merge by extending the end time
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap → add as a new interval
                result.add(current);
            }
        }

        // Convert list to array and return
        return result.toArray(new int[result.size()][]);
    }
}
