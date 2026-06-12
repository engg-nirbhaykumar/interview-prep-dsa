class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num; // Final xor = a ^ b
        }

        // Find rightmost set bit in xor
        int diffBit = xor & -xor;

        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num; // Group 1
            } else {
                b ^= num; // Group 2
            }
        }

        return new int[] { a, b };
    }
}
