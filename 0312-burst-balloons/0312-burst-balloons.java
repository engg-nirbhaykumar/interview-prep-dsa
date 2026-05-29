class Solution {
    int[] arr; // padded array with 1 at both ends
    int n;     // original length of nums[]
    Integer[][] dp; // memoization table

    // Recursive function to calculate max coins from interval [l..r]
    private int solve(int l, int r) {
        // Base case: no balloons left in this interval
        if (l > r) return 0;

        // If already computed, return stored result
        if (dp[l][r] != null) return dp[l][r];

        int maxCoins = 0;

        // Try making each balloon in [l..r] the last one to burst
        for (int i = l; i <= r; i++) {
            // Coins gained if balloon i is the last one burst:
            // arr[l-1] and arr[r+1] are neighbors of arr[i] at this moment
            int coins = arr[l - 1] * arr[i] * arr[r + 1]
                        + solve(l, i - 1) // coins from left side
                        + solve(i + 1, r); // coins from right side

            // Keep the best among all choices
            maxCoins = Math.max(maxCoins, coins);
        }

        // Store and return
        return dp[l][r] = maxCoins;
    }

    public int maxCoins(int[] nums) {
        n = nums.length;

        // Step 1: Pad the nums array with 1 at both ends
        arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        // Copy original nums into arr[1..n]
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // Initialize dp array with nulls
        dp = new Integer[n + 2][n + 2];

        // Step 2: Solve for interval [1..n] (original balloons)
        return solve(1, n);
    }
}
