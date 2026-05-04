class Solution {

    // Recursive + Memoization function
    // s = source string
    // t = target string
    // i = current index in s
    // j = current index in t
    // dp[i][j] stores minimum operations needed
    // to convert s[i...] into t[j...]
    private int solve(String s, String t,
                      int i, int j,
                      int n, int m,
                      int[][] dp) {

        // Base Case 1:
        // Source string finished
        // Need to insert remaining target chars
        if (i == n)
            return m - j;

        // Base Case 2:
        // Target string finished
        // Need to delete remaining source chars
        if (j == m)
            return n - i;

        // If already solved, return stored answer
        if (dp[i][j] != -1)
            return dp[i][j];

        // If current characters match
        if (s.charAt(i) == t.charAt(j)) {

            // No operation needed
            // Move both pointers
            return dp[i][j] =
                    solve(s, t,
                          i + 1, j + 1,
                          n, m, dp);

        } else {

            // Characters do not match

            // Case 1: Insert current target char into source
            // Move target pointer only
            int insert =
                    1 + solve(s, t,
                              i, j + 1,
                              n, m, dp);

            // Case 2: Delete current source char
            // Move source pointer only
            int delete =
                    1 + solve(s, t,
                              i + 1, j,
                              n, m, dp);

            // Case 3: Replace source char with target char
            // Move both pointers
            int replace =
                    1 + solve(s, t,
                              i + 1, j + 1,
                              n, m, dp);

            // Take minimum of all 3 operations
            return dp[i][j] =
                    Math.min(insert,
                    Math.min(delete, replace));
        }
    }

    public int minDistance(String s, String t) {

        int n = s.length();
        int m = t.length();

        // dp[i][j] stores answer for state (i,j)
        int[][] dp = new int[n][m];

        // Initialize with -1 (unvisited)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start recursion from first characters
        return solve(s, t,
                     0, 0,
                     n, m, dp);
    }
}