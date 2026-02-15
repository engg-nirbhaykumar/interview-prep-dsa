class Solution {

    // dp[i] stores the Fibonacci value of i
    // initialized with -1 to mark uncomputed states
    private int[] dp;

    // Recursive function with memoization
    private int backTrack(int n) {

        // Base cases:
        // fib(0) = 0, fib(1) = 1
        if (n == 0 || n == 1)
            return n;

        // If already computed, return cached value
        if (dp[n] != -1)
            return dp[n];

        // Compute, store, and return fib(n)
        // Using recursion for fib(n-1) and fib(n-2)
        return dp[n] = fib(n - 1) + fib(n - 2);
    }

    // Public API to compute Fibonacci
    public int fib(int n) {

        // Initialize dp array for memoization
        dp = new int[n + 1];

        // Fill dp with -1 indicating uncomputed states
        Arrays.fill(dp, -1);

        // Start recursive computation
        return backTrack(n);
    }
}
