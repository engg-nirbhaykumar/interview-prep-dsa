class Solution {
    public int jump(int[] nums) {

        int n = nums.length;

        // If array has 0 or 1 element, no jumps needed
        if (n <= 1)
            return 0;

        // left & right define the current "range" of indices
        // reachable with the current number of jumps
        int left = 0;
        int right = 0;

        int jumps = 0; // number of jumps taken

        // Continue until we can reach or pass last index
        while (right < n - 1) {

            int farthest = 0; // farthest index we can reach in next jump

            // Explore all positions in current range [left, right]
            for (int i = left; i <= right; i++) {
                // Update farthest reach from this level
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Move to next level (next jump range)
            left = right + 1;
            right = farthest;

            // We used one jump to move to this new range
            jumps++;
        }

        return jumps;
    }
}
