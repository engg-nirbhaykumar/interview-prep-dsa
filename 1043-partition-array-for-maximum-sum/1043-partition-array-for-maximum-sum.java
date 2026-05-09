class Solution {

    // Stores length of array
    private int n;

    // Memoization array:
    // dp[i] = maximum sum we can get starting from index i
    private int[] dp;

    private int solve(int i, int[] arr, int k) {

        // Base case:
        // If index goes beyond array, no elements left
        if (i >= n)
            return 0;

        // If already computed, return stored result
        if (dp[i] != -1)
            return dp[i];

        // Stores best answer for current index i
        int result = 0;

        // Tracks maximum element in current partition
        int currMax = -1;

        // Try all possible partitions starting at i
        // Partition size can be from 1 to k
        for (int j = i; j < n && j - i + 1 <= k; j++) {

            // Update max element in current partition arr[i...j]
            currMax = Math.max(currMax, arr[j]);

            // Current partition length
            int len = j - i + 1;

            // Partition contribution:
            // Every element becomes currMax
            int currentSum = len * currMax;

            // Remaining answer from next index
            int nextPart = solve(j + 1, arr, k);

            // Take maximum among all partition choices
            result = Math.max(result, currentSum + nextPart);
        }

        // Store result in dp and return
        return dp[i] = result;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {

        // Array length
        n = arr.length;

        // Initialize dp array
        dp = new int[n];

        // Fill with -1 meaning not calculated yet
        Arrays.fill(dp, -1);

        // Start recursion from index 0
        return solve(0, arr, k);
    }
}