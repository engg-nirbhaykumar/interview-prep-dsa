class Solution {
    public int searchInsert(int[] nums, int target) {

        // Pointer to the start of the array
        int low = 0;

        // Pointer to the end of the array
        int high = nums.length - 1;

        // Binary search loop
        while (low <= high) {

            // Calculate mid index safely (avoids overflow)
            int mid = low + (high - low) / 2;

            // If target is found, return its index
            if (nums[mid] == target) {
                return mid;
            }
            // If target is greater, search in the right half
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            // If target is smaller, search in the left half
            else {
                high = mid - 1;
            }
        }

        // If target is not found,
        // 'low' will be the correct position to insert the target
        return low;
    }
}
