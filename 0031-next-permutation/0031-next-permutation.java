class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the pivot index
        // Pivot is the first index from the right where
        // nums[pivotIndex] < nums[pivotIndex + 1]
        int pivotIndex = -1;
        for (int idx = n - 2; idx >= 0; idx--) {
            if (nums[idx] < nums[idx + 1]) {
                pivotIndex = idx;
                break; // stop once first decreasing element is found
            }
        }

        // Step 2: If pivot exists, find the successor
        // Successor is the smallest element greater than nums[pivotIndex]
        // present to the right of pivot
        if (pivotIndex != -1) {
            for (int successorIndex = n - 1; successorIndex > pivotIndex; successorIndex--) {
                if (nums[successorIndex] > nums[pivotIndex]) {
                    // Swap pivot with its successor
                    swap(nums, pivotIndex, successorIndex);
                    break;
                }
            }
        }

        // Step 3: Reverse the suffix
        // This ensures the smallest lexicographical order
        // after the pivot
        reverse(nums, pivotIndex + 1, n - 1);
    }

    // Utility function to swap two elements in the array
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    // Reverse elements between startIdx and endIdx (inclusive)
    private void reverse(int[] nums, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            swap(nums, startIdx, endIdx);
            startIdx++;
            endIdx--;
        }
    }
}
