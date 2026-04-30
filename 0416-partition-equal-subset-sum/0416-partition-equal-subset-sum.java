class Solution {

    // Recursive function to check if subset with given target exists
    private boolean solve(int[] nums, int target, int index, Boolean[][] dp) {

        // Base case:
        // If we are at first element
        if (index == 0) {
            // If target becomes 0 OR equals nums[0], subset is possible
            return target == 0 || target == nums[0];
        }

        // Invalid cases:
        // If target becomes negative OR index goes out of bounds
        if (target < 0 || index < 0)
            return false;

        // Memoization check:
        // If already computed, return stored result
        if (dp[index][target] != null) {
            return dp[index][target];
        }

        // Option 1: Do NOT take current element
        boolean notTake = solve(nums, target, index - 1, dp);

        // Option 2: Take current element (only if it does not exceed target)
        boolean take = false;
        if (nums[index] <= target) {
            take = solve(nums, target - nums[index], index - 1, dp);
        }

        // Store result in DP and return
        return dp[index][target] = take || notTake;
    }

    public boolean canPartition(int[] nums) {

        int n = nums.length;

        // Step 1: Calculate total sum of array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Step 2: If sum is odd → cannot divide into 2 equal subsets
        if (sum % 2 != 0)
            return false;

        // Step 3: Target becomes half of total sum
        int partitionSum = sum / 2;

        // DP table:
        // dp[i][t] = whether subset of first i elements can make target t
        Boolean[][] dp = new Boolean[n][partitionSum + 1];

        // Step 4: Start recursion from last index
        return solve(nums, partitionSum, n - 1, dp);
    }
}