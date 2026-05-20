class Solution {

    private int solve(int i,
            int n,
            int[] days,
            int[] costs,
            int[] dp) {

        // Base case:
        // All travel days are covered
        if (i >= n)
            return 0;

        // If already computed, return stored answer
        if (dp[i] != -1)
            return dp[i];

        // ------------------------------------------------
        // Option 1:
        // Buy 1-day pass
        //
        // Covers only current day
        // Move to next travel day
        // ------------------------------------------------
        int cost1 = costs[0] +
                solve(i + 1, n, days, costs, dp);

        // ------------------------------------------------
        // Option 2:
        // Buy 7-day pass
        //
        // Covers:
        // days[i] to days[i] + 6
        // ------------------------------------------------
        int j = i;

        int maxDays = days[i] + 7;

        // Find first uncovered travel day
        while (j < n && days[j] < maxDays) {
            j++;
        }

        int cost7 = costs[1] +
                solve(j, n, days, costs, dp);

        // ------------------------------------------------
        // Option 3:
        // Buy 30-day pass
        //
        // Covers:
        // days[i] to days[i] + 29
        // ------------------------------------------------
        j = i;

        maxDays = days[i] + 30;

        // Find first uncovered travel day
        while (j < n && days[j] < maxDays) {
            j++;
        }

        int cost30 = costs[2] +
                solve(j, n, days, costs, dp);

        // Return minimum cost among all options
        return dp[i] = Math.min(cost1,
                Math.min(cost7, cost30));
    }

    public int mincostTickets(int[] days, int[] costs) {

        int n = days.length;

        int[] dp = new int[n];

        // dp[i] stores:
        // minimum cost needed
        // starting from travel day i
        Arrays.fill(dp, -1);

        // Start recursion from first travel day
        return solve(0, n, days, costs, dp);
    }
}