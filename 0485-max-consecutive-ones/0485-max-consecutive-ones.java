class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxLength = 0;   // To store maximum window size of consecutive 1s
        int i = 0;           // Left pointer of the current valid window

        // j → right pointer of the sliding window
        for (int j = 0; j < n; j++) {

            // If we encounter a zero, we cannot include any previous elements.
            // So we move the left pointer to j + 1.
            if (nums[j] == 0) {
                i = j + 1;
            }

            // Update the maximum length of the window containing only 1s
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}
