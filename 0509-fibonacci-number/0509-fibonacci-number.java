class Solution {

    // Recursive function with memoization to calculate Fibonacci
    private int solve(int i, int[] dp) {

        // Base cases:
        // fib(0) = 0
        // fib(1) = 1
        if (i == 0 || i == 1)
            return i;

        // If already calculated, return stored result
        if (dp[i] != -1)
            return dp[i];

        // Store result after calculating recursively
        dp[i] = solve(i - 1, dp) + solve(i - 2, dp);

        return dp[i];
    }

    public int fib(int n) {

        // Create dp array to store Fibonacci values
        int[] dp = new int[n + 1];

        // Initialize all values as -1 (not computed yet)
        Arrays.fill(dp, -1);

        // Start recursion from n
        return solve(n, dp);
    }
}