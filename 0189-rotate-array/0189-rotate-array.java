class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // If k > n, rotating by n positions brings array back to original
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements (these will move to front)
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    // Helper function to reverse a portion of the array from index start to end
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements at start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
