class Solution {
    public int[] shuffle(int[] nums, int n) {

        // Create result array of size 2 * n
        int[] ans = new int[2 * n];

        // i -> index for result array
        // left -> points to first half [x1, x2, ..., xn]
        // right -> points to second half [y1, y2, ..., yn]
        int i = 0, left = 0, right = n;

        // Pick one element from first half and then one from second half
        while (left < n) {
            ans[i++] = nums[left++]; // Add xi
            ans[i++] = nums[right++]; // Add yi
        }

        // Return shuffled array
        return ans;
    }
}