class Solution {
    public int reverse(int x) {

        // Use long to safely detect overflow
        long rev = 0;

        // Process digits until x becomes 0
        while (x != 0) {

            // Extract last digit
            int digit = x % 10;

            // Build reversed number
            rev = rev * 10 + digit;

            // Remove last digit
            x = x / 10;
        }

        // Check if reversed number is outside 32-bit signed int range
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }

        // Safe to cast back to int
        return (int) rev;
    }
}
