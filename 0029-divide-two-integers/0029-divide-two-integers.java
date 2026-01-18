class Solution {

    public int divide(int dividend, int divisor) {

        // If both numbers are equal, result is 1
        if (dividend == divisor) return 1;

        // Overflow case: INT_MIN / -1 → exceeds Integer.MAX_VALUE
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Dividing by 1 returns the dividend itself
        if (divisor == 1) return dividend;

        // Special case: -1 / x
        if (dividend == -1) return -dividend;

        // Determine the sign of the result
        int sign = 1;
        if (dividend > 0 && divisor < 0) sign = -1;
        if (dividend < 0 && divisor > 0) sign = -1;

        // Convert to positive using long to avoid overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int ans = 0;

        // Perform division using bit shifting
        while (n >= d) {
            int p = 0;

            // Find the highest power such that (d << p) <= n
            while (n >= (d << p)) {
                p++;
            }

            // Step back to last valid power
            p--;

            // Subtract the largest shifted divisor
            n -= d << p;

            // Add corresponding power of two to answer
            ans += 1 << p;
        }

        // Handle overflow after calculation
        if (ans >= Math.pow(2, 31) && sign == 1) return Integer.MAX_VALUE;
        if (ans >= Math.pow(2, 31) && sign == -1) return Integer.MIN_VALUE;

        // Apply sign and return result
        return ans * sign;
    }
}
