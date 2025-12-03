class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int peak = 0; // Counts how many times the sorted order breaks

        for (int i = 0; i < n; i++) {

            // If nums[i] > nums[i+1], this indicates a "break" in sorted order.
            // Use modulo to compare last element with first element for circular check.
            if (nums[i] > nums[(i + 1) % n]) {
                peak++;
            }
        }

        // For a rotated sorted array, the order can break at most once.
        return peak <= 1;
    }
}
