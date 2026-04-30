class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // dp[i][a] = minimum coins needed using coins[0..i] to form amount 'a'
        int[][] dp = new int[n][amount + 1];

        // initialize with -1 (means not computed)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(coins, amount, n - 1, dp);

        return ans == (int) 1e9 ? -1 : ans;
    }

    private int solve(int[] coins, int amount, int index, int[][] dp) {

        // Base case
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return (int) 1e9;
            }
        }

        // If already computed, return stored value
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        // Not take
        int notTake = solve(coins, amount, index - 1, dp);

        // Take
        int take = (int) 1e9;
        if (coins[index] <= amount) {
            int sub = solve(coins, amount - coins[index], index, dp);
            if (sub != (int) 1e9) {
                take = 1 + sub;
            }
        }

        // Store and return result
        return dp[index][amount] = Math.min(take, notTake);
    }
}