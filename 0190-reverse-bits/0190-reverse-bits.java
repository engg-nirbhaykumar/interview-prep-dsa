public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1; // Left shift result to make space for the next bit
            result |= (n & 1); // Add the last bit of n to result
            n >>= 1; // Unsigned right shift n to get next bit (>> would sign-extend)
        }

        return result;
    }
}
