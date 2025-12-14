class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;

        // Variable to count the number of reverse pairs
        int count = 0;

        // Check every pair (i, j) such that i < j
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                // A reverse pair exists if:
                // nums[i] > 2 * nums[j]
                if (nums[i] > 2L * nums[j]) {
                    count++;
                }
            }
        }

        // Return total count of reverse pairs
        return count;
    }
}
