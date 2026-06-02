class Solution {

    private int m;
    private int n;
    private int[][] dp;

    private int solve(int i, int j, int[][] dungeon) {

        // Out of bounds path is invalid.
        // Return a very large value so it never gets selected.
        if (i >= m || j >= n)
            return (int) (1e9 + 7);

        // Return already computed result.
        if (dp[i][j] != -1)
            return dp[i][j];

        // Base case: reached princess cell (bottom-right).
        if (i == m - 1 && j == n - 1) {

            // If cell value is positive or zero,
            // knight only needs 1 HP to survive.
            if (dungeon[i][j] > 0)
                return 1;

            // If cell value is negative,
            // need enough HP to offset damage and still remain >= 1.
            return Math.abs(dungeon[i][j]) + 1;
        }

        // Minimum health required if we move right.
        int right = solve(i, j + 1, dungeon);

        // Minimum health required if we move down.
        int down = solve(i + 1, j, dungeon);

        // Choose the path requiring less health.
        int nextCellRequirement = Math.min(right, down);

        // Calculate health needed before entering current cell.
        // Current cell may increase or decrease health.
        int result = nextCellRequirement - dungeon[i][j];

        // Health can never be less than 1.
        return dp[i][j] = (result > 0) ? result : 1;
    }

    public int calculateMinimumHP(int[][] dungeon) {

        m = dungeon.length;
        n = dungeon[0].length;

        // Memoization table.
        // dp[i][j] = minimum health required to start
        // from cell (i, j) and safely reach destination.
        dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, dungeon);
    }
}