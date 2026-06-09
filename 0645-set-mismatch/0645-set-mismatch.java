class Solution {
    public int[] findErrorNums(int[] nums) {

        // Stores the duplicated and missing numbers
        int duplicate = -1;
        int missing = -1;

        // Mark visited numbers using the sign of elements
        for (int i = 0; i < nums.length; i++) {

            // Get the actual value (ignore previous sign changes)
            int num = Math.abs(nums[i]);

            // If the corresponding index is already negative,
            // this number has been seen before => duplicate
            if (nums[num - 1] < 0) {
                duplicate = num;
            } else {
                // Mark this number as visited
                nums[num - 1] *= -1;
            }
        }

        // Find the index that was never visited
        for (int i = 0; i < nums.length; i++) {

            // Positive value means (i + 1) was never encountered
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        // Return [duplicate, missing]
        return new int[] { duplicate, missing };
    }
}