class Solution {

    // Recursive + Memoization function
    // s = source string
    // t = target string
    // i = current index in s
    // j = current index in t
    // dp[i][j] stores number of distinct subsequences
    // of s[i...] that can form t[j...]
    private int solve(String s, String t,
                      int i, int j,
                      int n, int m,
                      int[][] dp) {

        // Base Case:
        // If target string fully matched
        if (j == m)
            return 1;

        // If source string ends before target
        if (i == n)
            return 0;

        // If already solved, return stored answer
        if (dp[i][j] != -1)
            return dp[i][j];

        int take = 0;
        int notTake = 0;

        // If current characters match
        if (s.charAt(i) == t.charAt(j)) {

            // Option 1:
            // Use current character of s
            take = solve(s, t,
                         i + 1, j + 1,
                         n, m, dp);

            // Option 2:
            // Skip current character of s
            notTake = solve(s, t,
                            i + 1, j,
                            n, m, dp);

        } else {

            // Characters do not match
            // Only option is skip current char of s
            notTake = solve(s, t,
                            i + 1, j,
                            n, m, dp);
        }

        // Total ways = take + skip
        return dp[i][j] = take + notTake;
    }

    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        // dp[i][j] stores answer for state (i,j)
        int[][] dp = new int[n][m];

        // Fill with -1 (unvisited state)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start recursion from first characters
        return solve(s, t,
                     0, 0,
                     n, m, dp);
    }
}