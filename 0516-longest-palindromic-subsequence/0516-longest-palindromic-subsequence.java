class Solution {

    // Recursive + Memoization function
    // s = input string
    // i = starting index
    // j = ending index
    // dp[i][j] stores Longest Palindromic Subsequence
    // length in substring s[i...j]
    private int solve(String s, int i, int j, int[][] dp) {

        // Base Case:
        // Invalid substring
        if (i > j)
            return 0;

        // Single character is palindrome of length 1
        if (i == j)
            return 1;

        // If already solved, return stored answer
        if (dp[i][j] != -1)
            return dp[i][j];

        // If both end characters match
        if (s.charAt(i) == s.charAt(j)) {

            // Include both characters
            // Move inward
            return dp[i][j] =
                    2 + solve(s, i + 1, j - 1, dp);

        } else {

            // Characters do not match

            // Option 1: Skip left character
            int skipLeft =
                    solve(s, i + 1, j, dp);

            // Option 2: Skip right character
            int skipRight =
                    solve(s, i, j - 1, dp);

            // Take maximum
            return dp[i][j] =
                    Math.max(skipLeft, skipRight);
        }
    }

    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        // dp[i][j] = answer for substring i to j
        int[][] dp = new int[n][n];

        // Fill with -1 (unvisited state)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Solve for complete string
        return solve(s, 0, n - 1, dp);
    }
}