class Solution {
    public int search(int[] nums, int target) {

        // Left pointer at start of array
        int left = 0;

        // Right pointer at end of array
        int right = nums.length - 1;

        // Binary Search loop
        while (left <= right) {

            // Find mid index (prevents integer overflow)
            int mid = left + (right - left) / 2;

            // If target is found at mid, return its index
            if (nums[mid] == target) {
                return mid;
            }
            // If target is greater than mid element,
            // search in the right half
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller than mid element,
            // search in the left half
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}
