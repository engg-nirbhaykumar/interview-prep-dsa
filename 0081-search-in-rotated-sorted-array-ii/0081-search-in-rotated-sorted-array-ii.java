class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            while (low < high && nums[low] == nums[low + 1]) {
                low++;
            }
            while (low < high && nums[high] == nums[high - 1]) {
                high--;
            }
            int mid = low + (high - low) / 2; // avoid overflow

            // If mid is the target, return index
            if (nums[mid] == target) {
                return true;
            }

            // Check which side is sorted (Left half sorted?)
            if (nums[low] <= nums[mid]) {

                // If target lies within sorted left part → shrink right
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    // otherwise shift to right side
                    low = mid + 1;
                }

            } else { // Right half is sorted

                // if target lies between mid and high → move right
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    // otherwise go to left half
                    high = mid - 1;
                }
            }
        }

        // not found
        return false;
    }
}