class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        // If array has 2 or fewer elements, it's already valid
        if (n <= 2)
            return n;

        int index = 2; // Start from 2nd index

        for (int i = 2; i < n; i++) {
            // Compare current element with the element at index - 2
            // If it's not the same, we can safely keep it
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index; // New length of array
    }
}