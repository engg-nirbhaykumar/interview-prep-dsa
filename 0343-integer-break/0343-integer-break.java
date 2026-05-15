class Solution {

    private int solve(int n, int[] dp) {

        // Base case:
        // If number becomes 1,
        // maximum product possible is 1 itself
        if (n == 1)
            return 1;

        // If already computed, return stored answer
        if (dp[n] != -1)
            return dp[n];

        int maxProd = Integer.MIN_VALUE;
        // Stores maximum product possible for current n

        // Try every possible first cut
        // Split n into:
        // i and (n - i)
        for (int i = 1; i <= n - 1; i++) {

            // Two choices for second part:
            //
            // 1. Do not break (n - i) further
            //    => product = i * (n - i)
            //
            // 2. Break (n - i) further recursively
            //    => product = i * solve(n - i)
            //
            // Take whichever gives larger product

            int prod = i * Math.max(n - i, solve(n - i, dp));

            // Update maximum product
            maxProd = Math.max(maxProd, prod);
        }

        // Store and return answer for current n
        return dp[n] = maxProd;
    }

    public int integerBreak(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);
        // dp[i] stores maximum product obtainable from integer i

        // Start recursion from n
        return solve(n, dp);
    }
}