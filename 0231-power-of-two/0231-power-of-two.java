class Solution {

    // Checks if a number is a power of two
    // Power of two numbers have exactly one set bit in binary representation
    // n & (n - 1) removes the lowest set bit
    // If the result becomes 0, it means only one set bit was present
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
