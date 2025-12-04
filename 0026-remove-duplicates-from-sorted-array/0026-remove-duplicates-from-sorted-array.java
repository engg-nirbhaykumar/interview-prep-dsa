class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        // If the array has 0 or 1 elements, it is already unique
        if (n < 2)
            return n;

        // 'index' points to the position where the next unique element should be placed.
        // Start from 1 because the first element is always unique.
        int index = 1;

        // Start checking from the 2nd element (i = 1)
        for (int i = 1; i < n; i++) {

            // Compare current element with the last placed unique element (nums[index - 1]).
            // If they are different, it's a new unique element.
            if (nums[i] != nums[index - 1]) {
                nums[index] = nums[i]; // Place the unique element at 'index'
                index++;               // Move index ahead
            }
        }

        // 'index' now represents the count of unique elements.
        return index;
    }
}
