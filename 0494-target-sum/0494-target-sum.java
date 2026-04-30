class Solution {

    private int solve(int[] nums, int target, int currSum, int index,
            Map<String, Integer> memo) {

        // Base case
        if (index == nums.length) {
            return currSum == target ? 1 : 0;
        }

        // Create unique state key
        String key = index + "|" + currSum;

        // Check memo
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // + sign
        int plus = solve(nums, target, currSum + nums[index], index + 1, memo);

        // - sign
        int minus = solve(nums, target, currSum - nums[index], index + 1, memo);

        int res = plus + minus;

        // Store result
        memo.put(key, res);

        return res;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0, new HashMap<>());
    }
}