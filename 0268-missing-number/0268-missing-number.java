class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // XOR accumulator
        int xor = 0;

        // Step 1: XOR all numbers from 0 to n
        // This includes the missing number as well.
        for (int i = 0; i <= n; i++) {
            xor = xor ^ i;
        }

        // Step 2: XOR all elements of the array
        // All numbers that exist in both sets (0..n and nums[])
        // will cancel out because x ^ x = 0.
        // Only the missing number will remain.
        for (int num : nums) {
            xor = xor ^ num;
        }
        
        // The remaining value in xor is the missing number.
        return xor;
    }
}
