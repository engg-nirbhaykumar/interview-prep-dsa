class Solution {

    // All valid row patterns for 3 columns
    //
    // Conditions inside a row:
    // Adjacent cells must have different colors
    //
    // Example:
    // "RYG" is valid
    // "RRG" is invalid because adjacent colors are same
    private String[] states = {
            "RYG", "RGY", "RYR", "RGR",
            "YRG", "YGR", "YGY", "YRY",
            "GRY", "GYR", "GRG", "GYG"
    };

    // Mod value to avoid integer overflow
    private int M = 1_000_000_007;

    private int solve(int n, int prev, int[][] dp) {

        // Base case:
        // No more rows left to fill
        if (n == 0)
            return 1;

        // If already computed, return stored answer
        if (dp[n][prev] != -1)
            return dp[n][prev];

        // Previous row pattern
        String last = states[prev];

        int result = 0;
        // Stores total valid ways

        // Try every possible current row pattern
        for (int curr = 0; curr < 12; curr++) {

            String currPat = states[curr];

            boolean isConflict = false;

            // Check vertical adjacency conflict
            //
            // Same column in adjacent rows
            // cannot have same color
            for (int col = 0; col < 3; col++) {

                if (currPat.charAt(col) == last.charAt(col)) {
                    isConflict = true;
                    break;
                }
            }

            // If no conflict,
            // current pattern can be placed
            if (!isConflict) {

                result = (result + solve(n - 1, curr, dp)) % M;
            }
        }

        // Store and return answer
        return dp[n][prev] = result;
    }

    public int numOfWays(int n) {

        int[][] dp = new int[n][12];

        // dp[rowRemaining][prevPattern]
        //
        // Stores number of ways to color remaining rows
        // when previous row pattern is prevPattern

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = 0;

        // Try every possible pattern for first row
        for (int i = 0; i < 12; i++) {

            result = (result + solve(n - 1, i, dp)) % M;
        }

        return result;
    }
}