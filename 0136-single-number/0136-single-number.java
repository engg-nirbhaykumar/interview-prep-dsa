class Solution {
    public int singleNumber(int[] nums) {

        // XOR accumulator — will store the unique element
        int xor = 0;

        // Traverse all numbers
        for (int num : nums) {

            // XOR does two important things:
            // 1. num ^ num = 0  → pairs cancel each other
            // 2. x ^ 0 = x      → keeps unique element intact
            //
            // Since every element except one appears twice,
            // all pairs cancel out and only the single number remains.
            xor = xor ^ num;
        }

        // The remaining value is the number that occurs only once
        return xor;
    }
}
