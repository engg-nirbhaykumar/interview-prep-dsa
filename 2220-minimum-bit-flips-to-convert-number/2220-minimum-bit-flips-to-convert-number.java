class Solution {

    // Returns the minimum number of bit flips required
    // to convert 'start' into 'goal'
    public int minBitFlips(int start, int goal) {

        // XOR highlights the bits that are different
        // Bits with value 1 in 'diff' need to be flipped
        int diff = start ^ goal;

        int count = 0;

        // Brian Kernighan’s Algorithm to count set bits
        // Each iteration removes the rightmost set bit
        while (diff != 0) {
            diff = diff & (diff - 1); // remove lowest set bit
            count++;
        }

        // Total number of differing bits = minimum flips
        return count;
    }
}
