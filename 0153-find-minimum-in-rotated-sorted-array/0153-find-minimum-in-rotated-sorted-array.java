class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // Continue searching while search range is valid
        while (low < high) {
            int mid = low + (high - low) / 2; // prevents integer overflow

            // If mid element is greater than the rightmost element
            // it means minimum lies in the RIGHT half
            // because rotation happened to the right side
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            else {
                // Otherwise, minimum lies in the LEFT half including mid
                // So move high pointer to mid (not mid - 1)
                high = mid;
            }
        }

        // low == high → minimum element index found
        return nums[low];
    }
}
