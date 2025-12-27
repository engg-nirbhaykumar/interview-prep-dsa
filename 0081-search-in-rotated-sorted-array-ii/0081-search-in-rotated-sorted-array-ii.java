class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            // Skip duplicate values from both ends to avoid ambiguity
            while (low < high && nums[low] == nums[low + 1]) {
                low++;
            }
            while (low < high && nums[high] == nums[high - 1]) {
                high--;
            }

            int mid = low + (high - low) / 2;  // prevent integer overflow

            // Found target
            if (nums[mid] == target) {
                return true;
            }

            // Determine which half is sorted
            // LEFT part sorted?
            if (nums[low] <= nums[mid]) {

                // Target lies in LEFT sorted range?
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;  // shrink right
                } else {
                    low = mid + 1;   // move to right half
                }

            } else { 
                // RIGHT part must be sorted

                // Target lies in RIGHT sorted range?
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;   // move right
                } else {
                    high = mid - 1;  // move left
                }
            }
        }

        // target not found
        return false;
    }
}
