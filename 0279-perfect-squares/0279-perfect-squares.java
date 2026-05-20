class Solution {

    private int solve(int n, int[] dp) {

        // Base case:
        // If number becomes 0,
        // no more squares are needed
        if (n == 0)
            return 0;

        // If already computed, return stored answer
        if (dp[n] != -1)
            return dp[n];

        int result = Integer.MAX_VALUE;
        // Stores minimum number of perfect squares needed

        // Try every perfect square <= n
        //
        // i*i represents:
        // 1, 4, 9, 16, ...
        for (int i = 1; i * i <= n; i++) {

            // Take current perfect square
            //
            // 1 count for current square
            // + answer for remaining value
            int take = 1 + solve(n - i * i, dp);

            // Keep minimum answer
            result = Math.min(result, take);
        }

        // Store and return answer
        return dp[n] = result;
    }

    public int numSquares(int n) {

        int[] dp = new int[n + 1];

        // Initialize DP with -1
        Arrays.fill(dp, -1);

        // Start recursion from n
        return solve(n, dp);
    }
}