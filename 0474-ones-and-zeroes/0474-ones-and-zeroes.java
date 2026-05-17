class Solution {

    private int solve(int i, int m, int n,
            int[][] count,
            int[][][] dp) {

        // Base case:
        // If all strings are processed
        // OR no zeros and ones are left
        if (i >= count.length || (m == 0 && n == 0)) {
            return 0;
        }

        // If already computed, return stored answer
        if (dp[m][n][i] != -1) {
            return dp[m][n][i];
        }

        int take = 0;

        // Check if current string can be included
        //
        // count[i][0] = zeros needed
        // count[i][1] = ones needed
        if (count[i][0] <= m && count[i][1] <= n) {

            // Include current string
            //
            // Reduce available zeros and ones
            take = 1 + solve(
                    i + 1,
                    m - count[i][0],
                    n - count[i][1],
                    count,
                    dp);
        }

        // Option 2: Skip current string
        int notTake = solve(i + 1, m, n, count, dp);

        // Store and return maximum subset size
        return dp[m][n][i] = Math.max(take, notTake);
    }

    public int findMaxForm(String[] strs, int m, int n) {

        int L = strs.length;
        // Total number of strings

        int[][] count = new int[L][2];
        // count[i][0] = number of zeros in strs[i]
        // count[i][1] = number of ones in strs[i]

        int[][][] dp = new int[m + 1][n + 1][L];

        // Initialize DP with -1
        for (int[][] r1 : dp) {
            for (int[] row : r1) {
                Arrays.fill(row, -1);
            }
        }

        // Precompute zeros and ones count
        // for every string
        for (int i = 0; i < L; i++) {

            int zeros = 0;
            int ones = 0;

            for (char ch : strs[i].toCharArray()) {

                if (ch == '0') {
                    zeros++;
                } else if (ch == '1') {
                    ones++;
                }
            }

            count[i][0] = zeros;
            count[i][1] = ones;
        }

        // Start recursion from index 0
        return solve(0, m, n, count, dp);
    }
}