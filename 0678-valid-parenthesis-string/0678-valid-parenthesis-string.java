class Solution {

    // dp[index][count] → stores whether substring from 'index'
    // with 'count' open brackets is valid or not
    private Boolean[][] dp;

    // index → current position in string
    // count → number of unmatched '(' so far
    private boolean backTrack(String s, int index, int count) {

        // If we processed entire string
        // Valid only if no unmatched '(' remain
        if (index == s.length()) {
            return count == 0;
        }

        // If ')' exceed '(' at any point → invalid
        if (count < 0) {
            return false;
        }

        // Return memoized result if already computed
        if (dp[index][count] != null)
            return dp[index][count];

        char ch = s.charAt(index);

        // Case 1: Current char is '('
        // Increase open bracket count
        if (ch == '(') {
            return dp[index][count] = backTrack(s, index + 1, count + 1);
        }

        // Case 2: Current char is ')'
        // Decrease open bracket count
        else if (ch == ')') {
            return dp[index][count] = backTrack(s, index + 1, count - 1);
        }

        // Case 3: Current char is '*'
        // '*' can act as:
        // 1. '('  → count + 1
        // 2. ')'  → count - 1
        // 3. empty → count stays same
        else {
            return dp[index][count] =
                    backTrack(s, index + 1, count + 1) ||  // treat '*' as '('
                    backTrack(s, index + 1, count - 1) ||  // treat '*' as ')'
                    backTrack(s, index + 1, count);        // treat '*' as empty
        }
    }

    public boolean checkValidString(String s) {
        int n = s.length();

        // dp size:
        // index → 0 to n
        // count → 0 to n (max '(' possible)
        dp = new Boolean[n + 1][n + 1];

        return backTrack(s, 0, 0);
    }
}
