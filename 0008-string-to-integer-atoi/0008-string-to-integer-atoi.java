class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        // Skip leading whitespace characters
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If the string contains only spaces, return 0
        if (i == n)
            return 0;

        int sign = 1;

        // Check for optional sign character
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        long result = 0; // Using long to safely detect overflow

        // Convert digit characters to integer value
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // Overflow check for positive numbers
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            // Overflow check for negative numbers
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        // Apply sign and return final result
        return (int) (sign * result);
    }
}