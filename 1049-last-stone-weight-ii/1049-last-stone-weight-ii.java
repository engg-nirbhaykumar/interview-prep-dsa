class Solution {

    private int solve(int i,
            int currSum,
            int totalSum,
            int[] stones,
            int[][] dp) {

        // Base case:
        // All stones are processed
        if (i >= stones.length) {

            // currSum represents sum of subset 1

            int subset1Sum = totalSum - currSum;

            // Remaining stones automatically form subset 2
            int subset2Sum = totalSum - subset1Sum;

            // Final remaining stone weight
            // = absolute difference of both subsets
            return Math.abs(subset1Sum - subset2Sum);
        }

        // If already computed, return stored result
        if (dp[i][currSum] != -1) {
            return dp[i][currSum];
        }

        // Option 1:
        // Put current stone into current subset
        int take = solve(
                i + 1,
                currSum + stones[i],
                totalSum,
                stones,
                dp);

        // Option 2:
        // Do not include current stone
        // in current subset
        int notTake = solve(
                i + 1,
                currSum,
                totalSum,
                stones,
                dp);

        // Store and return minimum possible difference
        return dp[i][currSum] = Math.min(take, notTake);
    }

    public int lastStoneWeightII(int[] stones) {

        int n = stones.length;

        int totalSum = 0;

        // Calculate total sum of all stones
        for (int stone : stones) {
            totalSum += stone;
        }

        int[][] dp = new int[n][totalSum + 1];

        // Initialize DP array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start recursion from index 0
        // with current subset sum = 0
        return solve(0, 0, totalSum, stones, dp);
    }
}