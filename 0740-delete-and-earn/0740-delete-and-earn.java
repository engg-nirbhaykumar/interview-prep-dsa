class Solution {

    private int solve(int i, int[] points, int[] dp) {

        // Base case:
        // If index goes beyond available numbers, no points can be earned
        if (i >= points.length) {
            return 0;
        }

        // If already computed, return stored answer
        if (dp[i] != -1)
            return dp[i];

        // Option 1: Take current number i
        // Earn points[i], but must skip i + 1
        int take = points[i] + solve(i + 2, points, dp);

        // Option 2: Skip current number i
        // Move to next number
        int skip = solve(i + 1, points, dp);

        // Store and return maximum of both choices
        return dp[i] = Math.max(take, skip);
    }

    public int deleteAndEarn(int[] nums) {

        int maxVal = 0;

        // Find maximum number in array
        // Needed to size points[] and dp[]
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] dp = new int[maxVal + 1];
        Arrays.fill(dp, -1);
        // dp[i] stores max points starting from number i

        int[] points = new int[maxVal + 1];

        // Convert input into points array
        // points[i] = total score gained if all i's are taken
        for (int num : nums) {
            points[num] += num;
        }

        // Start recursion from number 0
        return solve(0, points, dp);
    }
}