class Solution {

    private Boolean[][] dp;

    private boolean solve(String s, String p, int i, int j) {

        int n = s.length();
        int m = p.length();

        if (i == n && j == m)
            return true;

        if (j == m)
            return false;

        if (dp[i][j] != null)
            return dp[i][j];

        // If string ended, remaining pattern must be all *
        if (i == n) {
            for (int k = j; k < m; k++) {
                if (p.charAt(k) != '*')
                    return dp[i][j] = false;
            }
            return dp[i][j] = true;
        }

        boolean ans;

        if (p.charAt(j) == '?'
                || s.charAt(i) == p.charAt(j)) {

            ans = solve(s, p, i + 1, j + 1);

        } else if (p.charAt(j) == '*') {

            ans = solve(s, p, i, j + 1) // empty
                    || solve(s, p, i + 1, j); // consume char

        } else {
            ans = false;
        }

        return dp[i][j] = ans;
    }

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s, p, 0, 0);
    }
}