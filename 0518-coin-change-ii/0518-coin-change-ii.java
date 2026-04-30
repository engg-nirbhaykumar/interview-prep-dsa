class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        // dp[index][amount] = number of ways
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(coins, amount, n - 1, dp);
    }

    private int solve(int[] coins, int amount, int index, int[][] dp) {

        // Base case
        if (index == 0) {
            // If amount can be formed using only this coin
            return (amount % coins[0] == 0) ? 1 : 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        // Not take current coin
        int notTake = solve(coins, amount, index - 1, dp);

        // Take current coin
        int take = 0;
        if (coins[index] <= amount) {
            take = solve(coins, amount - coins[index], index, dp);
        }

        return dp[index][amount] = take + notTake;
    }
}