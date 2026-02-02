class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;

        // maxIdx = farthest index we can currently reach
        // Initially we can reach up to nums[0] from index 0
        int maxIdx = 0 + nums[0];

        // Traverse array
        for (int i = 1; i < n; i++) {

            // If current index is beyond the farthest reachable index,
            // we cannot land here → impossible to reach end
            if (i > maxIdx)
                return false;

            // Update the farthest reachable index
            // Either previous max or jumping from current position
            maxIdx = Math.max(maxIdx, i + nums[i]);
        }

        // If we never got stuck, we can reach the last index
        return true;
    }
}
