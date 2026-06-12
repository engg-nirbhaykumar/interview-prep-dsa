class Solution {
    public int getSum(int a, int b) {
        // Continue the loop until there are no carries left
        while (b != 0) {
            // Calculate the carry
            int carry = a & b;
            // Calculate sum ignoring the carry
            a = a ^ b;
            // Update the carry, shifted left
            b = carry << 1;
        }
        // Finally, a contains the sum
        return a;
    }
}