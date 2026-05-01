class Solution {

    // Recursive + Memoization function
    // s1, s2 = input strings
    // i = current index in s1
    // j = current index in s2
    // n = length of s1
    // m = length of s2
    // dp[i][j] stores LCS length starting from i and j
    private int solve(String s1, String s2,
            int i, int j,
            int n, int m,
            Integer[][] dp) {

        // Base Case:
        // If any string is fully traversed,
        // no common subsequence possible
        if (i >= n || j >= m)
            return 0;

        // If already solved, return stored answer
        if (dp[i][j] != null)
            return dp[i][j];

        // If characters match
        if (s1.charAt(i) == s2.charAt(j)) {

            // Include current character in LCS
            // Move both pointers forward
            return dp[i][j] = 1 + solve(s1, s2,
                    i + 1, j + 1,
                    n, m, dp);

        } else {

            // Characters do not match

            // Option 1: Skip character from s1
            int skipS1 = solve(s1, s2,
                    i + 1, j,
                    n, m, dp);

            // Option 2: Skip character from s2
            int skipS2 = solve(s1, s2,
                    i, j + 1,
                    n, m, dp);

            // Take maximum of both choices
            return dp[i][j] = Math.max(skipS1, skipS2);
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {

        // Lengths of both strings
        int n = text1.length();
        int m = text2.length();

        // Memoization table
        // dp[i][j] = LCS starting from index i and j
        Integer[][] dp = new Integer[n][m];

        // Start from first characters
        return solve(text1, text2,
                0, 0,
                n, m, dp);
    }
}