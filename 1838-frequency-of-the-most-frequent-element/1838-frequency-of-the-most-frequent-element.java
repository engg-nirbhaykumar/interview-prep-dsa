class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;

        // Result to store maximum frequency found
        int result = 0;

        // Left pointer of the sliding window
        int left = 0;

        // Sum of elements in the current window
        long currentSum = 0;

        // Sort the array so we can make elements equal by only incrementing
        Arrays.sort(nums);

        // Expand the window using right pointer
        for (int right = 0; right < n; right++) {

            // Add current element to window sum
            currentSum += nums[right];

            // We try to make all elements in the window equal to nums[right]
            int target = nums[right];

            // Total sum needed if all elements in window become 'target'
            long originalSum = (long) (right - left + 1) * target;

            // If required increments exceed k, shrink window from left
            if (originalSum - currentSum > k) {
                currentSum -= nums[left]; // remove left element from sum
                left++; // shrink window
            }

            // Update result with the valid window size
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
