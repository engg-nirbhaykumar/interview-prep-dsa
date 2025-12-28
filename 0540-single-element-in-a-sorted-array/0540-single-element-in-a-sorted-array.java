class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // Binary search for the position where pairing pattern breaks
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Case 1: nums[mid] forms a valid pair with nums[mid + 1]
            if (nums[mid] == nums[mid + 1]) {

                // Count how many elements are on the right side including mid
                // If the count is even -> single element is on the right half
                if ((high - mid) % 2 == 0) {
                    low = mid + 2; // skip this valid pair
                } else {
                    // If count is odd -> single element lies in the left half
                    high = mid - 1;
                }
            }

            // Case 2: nums[mid] does NOT form a pair with nums[mid + 1]
            else {
                // If right side length is even -> single element is at mid or lies to the left
                if ((high - mid) % 2 == 0) {
                    high = mid; // keep mid in search range
                } else {
                    // Otherwise single element is to the right
                    low = mid + 1;
                }
            }
        }

        // low == high gives index where the single non-duplicate exists
        return nums[low];
    }
}
