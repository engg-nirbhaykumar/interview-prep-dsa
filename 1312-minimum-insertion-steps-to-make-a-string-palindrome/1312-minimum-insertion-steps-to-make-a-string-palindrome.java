class Solution {

    // Recursive + Memoization function
    // s = input string
    // i = left index
    // j = right index
    // dp[i][j] stores minimum insertions needed
    // to make substring s[i...j] palindrome
    private int solve(String s, int i, int j, int[][] dp) {

        // Base Case:
        // Empty substring
        if (i > j)
            return 0;

        // Single character is already palindrome
        // No insertion needed
        if (i == j)
            return 0;

        // If already solved, return stored answer
        if (dp[i][j] != -1)
            return dp[i][j];

        // If both end characters match
        if (s.charAt(i) == s.charAt(j)) {

            // No insertion needed at ends
            // Solve inner substring
            return dp[i][j] = solve(s, i + 1, j - 1, dp);

        } else {

            // Characters do not match

            // Option 1:
            // Insert matching char near left side
            int insertLeft = 1 + solve(s, i + 1, j, dp);

            // Option 2:
            // Insert matching char near right side
            int insertRight = 1 + solve(s, i, j - 1, dp);

            // Take minimum insertions
            return dp[i][j] = Math.min(insertLeft, insertRight);
        }
    }

    public int minInsertions(String s) {

        int n = s.length();

        // dp[i][j] stores answer for substring i..j
        int[][] dp = new int[n][n];

        // Initialize with -1 (unvisited)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Solve for full string
        return solve(s, 0, n - 1, dp);
    }
}