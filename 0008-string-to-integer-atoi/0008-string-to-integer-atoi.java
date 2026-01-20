class Solution {

    // Converts a string to a 32-bit signed integer (atoi implementation)
    public int myAtoi(String s) {

        int n = s.length();
        int i = 0;

        // Step 1: Ignore leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if(i == n) return 0;
        

        // Step 2: Determine the sign
        int sign = 1;

        // Check for optional '+' or '-' sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        long result = 0;

        // Step 3: Convert digits to number
        while (i < n && Character.isDigit(s.charAt(i))) {

            // Build the number digit by digit
            result = result * 10 + (s.charAt(i) - '0');

            // Step 4: Handle overflow
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        // Step 5: Apply sign and return final result
        return (int) (sign * result);
    }
}
