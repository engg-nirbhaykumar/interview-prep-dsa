class Solution {

    // Recursive + Memoization function
    // dp[i][j] = LCS length starting from index i in s1 and j in s2
    private int solve(String s1, String s2,
                      int i, int j,
                      int n, int m,
                      Integer[][] dp) {

        // Base Case:
        // If any string ends
        if (i >= n || j >= m)
            return 0;

        // Already solved
        if (dp[i][j] != null)
            return dp[i][j];

        // If characters match
        if (s1.charAt(i) == s2.charAt(j)) {

            return dp[i][j] =
                    1 + solve(s1, s2,
                              i + 1, j + 1,
                              n, m, dp);
        }

        // Skip one character from either string
        int skipS1 = solve(s1, s2,
                           i + 1, j,
                           n, m, dp);

        int skipS2 = solve(s1, s2,
                           i, j + 1,
                           n, m, dp);

        return dp[i][j] =
                Math.max(skipS1, skipS2);
    }

    // LCS function
    private int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        Integer[][] dp = new Integer[n][m];

        return solve(text1, text2,
                     0, 0,
                     n, m, dp);
    }

    // Reverse string correctly
    private String reverse(String s) {

        char[] arr = s.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return new String(arr);
    }

    public int longestPalindromeSubseq(String s) {

        // Reverse string
        String s2 = reverse(s);

        // LPS = LCS(original, reversed)
        return longestCommonSubsequence(s, s2);
    }
}