class Solution {

    // Checks if using 'mid' as divisor keeps the sum within 'threshold'
    private boolean isPossible(int[] nums, int threshold, int mid) {

        int sum = 0;  // Total sum of ceil(num / mid)

        for (int num : nums) {
            // Ceil division: ceil(num / mid)
            sum += (num + mid - 1) / mid;

            // If sum already exceeds threshold, no need to continue
            if (sum > threshold)
                return false;
        }

        // True if total sum is within allowed threshold
        return sum <= threshold;
    }

    // Finds the maximum element in nums
    // This becomes the upper bound for binary search
    private int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;              // Minimum possible divisor
        int high = getMax(nums);  // Maximum possible divisor

        int result = high;        // Stores the best (minimum) valid divisor

        // Binary search on divisor value
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if current divisor works
            if (isPossible(nums, threshold, mid)) {
                result = mid;     // mid is a valid answer
                high = mid - 1;   // Try to find smaller valid divisor
            } else {
                low = mid + 1;    // mid is too small, increase divisor
            }
        }

        return result;
    }
}
