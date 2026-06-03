class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // pointer for the new array

        for (int j = 0; j < nums.length; j++) {
            // Only keep elements not equal to val
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i; // new length of the array
    }
}