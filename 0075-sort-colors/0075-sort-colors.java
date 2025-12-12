class Solution {

    // Helper function to swap two elements in the array using their indices
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {

        // Dutch National Flag Algorithm
        // low  → boundary for placing 0s
        // mid  → current index scanning the array
        // high → boundary for placing 2s
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // Process elements until mid crosses high
        while (mid <= high) {

            // Case 1 → nums[mid] == 0
            // Swap it to the front (low pointer)
            // Increment both low & mid because both are settled
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }

            // Case 2 → nums[mid] == 1
            // 1 is already in correct "middle" region → just move mid
            else if (nums[mid] == 1) {
                mid++;
            }

            // Case 3 → nums[mid] == 2
            // Swap it with element at high pointer
            // Only decrement high because mid's new value must be checked again
            else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }
}
