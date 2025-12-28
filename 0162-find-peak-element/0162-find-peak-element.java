class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Handle edge cases:
        // If array length is 1 OR first element is greater than its next, the first index is a peak
        if (n == 1 || nums[0] > nums[1]) {
            return 0;
        }

        // If last element is greater than its previous, then last index is a peak
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        // Search space is restricted between 1 and n-2
        // because we already checked both boundaries
        int low = 1;
        int high = n - 1;

        // Binary search to find a peak position
        // A peak exists because nums[i] != nums[i+1] (based on problem property)
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a valid peak (greater than both neighbors)
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            // If we are on a descending slope (nums[mid] > nums[mid + 1])
            // then a peak must lie on the left side (including mid)
            else if (nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            }
            // Otherwise we are on an ascending slope (nums[mid] < nums[mid + 1])
            // which means a peak is guaranteed to lie on the right side
            else {
                low = mid + 1;
            }
        }

        // When low == high, we converge to a peak position
        return low;
    }
}
