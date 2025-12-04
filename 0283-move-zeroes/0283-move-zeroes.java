class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        // This pointer keeps track of the position where the next non-zero should be placed.
        int lastNonZeroIndex = 0;

        // First pass: Move all non-zero elements to the front (in the same order).
        for (int i = 0; i < n; i++) {
            // If current element is non-zero, place it at lastNonZeroIndex
            // and then move the pointer ahead.
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        // Second pass: Fill the remaining positions with zeros.
        // All non-zero elements are already placed in the beginning,
        // so the rest must be zeros.
        while (lastNonZeroIndex < n) {
            nums[lastNonZeroIndex++] = 0;
        }
    }
}
