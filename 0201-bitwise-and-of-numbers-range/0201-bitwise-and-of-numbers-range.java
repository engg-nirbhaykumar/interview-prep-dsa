class Solution {

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Find common prefix
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        // Shift the prefix back to its original position
        return left << shift;
    }
}
