class Solution {

    // Recursive + Memoization function
    // i = current index in word1
    // j = current index in word2
    // dp[i][j] stores minimum deletions needed
    // for substrings word1[i...] and word2[j...]
    private int solve(String word1, String word2,
                      int i, int j,
                      int n, int m,
                      Integer[][] dp) {

        // Base Case:
        // If word1 finished,
        // delete remaining chars of word2
        if (i == n)
            return m - j;

        // If word2 finished,
        // delete remaining chars of word1
        if (j == m)
            return n - i;

        // Already solved
        if (dp[i][j] != null)
            return dp[i][j];

        // If characters match
        if (word1.charAt(i) == word2.charAt(j)) {

            // No deletion needed
            return dp[i][j] =
                    solve(word1, word2,
                          i + 1, j + 1,
                          n, m, dp);
        }

        // Delete from word1
        int deleteW1 =
                1 + solve(word1, word2,
                          i + 1, j,
                          n, m, dp);

        // Delete from word2
        int deleteW2 =
                1 + solve(word1, word2,
                          i, j + 1,
                          n, m, dp);

        // Take minimum deletions
        return dp[i][j] =
                Math.min(deleteW1, deleteW2);
    }

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // Memoization table
        Integer[][] dp =
                new Integer[n][m];

        return solve(word1, word2,
                     0, 0,
                     n, m, dp);
    }
}