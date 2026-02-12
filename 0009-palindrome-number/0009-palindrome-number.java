class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers cannot be palindrome
        // because of the '-' sign (e.g., -121 != 121-)
        if (x < 0)
            return false;

        // Store original value to compare later
        int original = x;

        // This will hold the reversed number
        int reversed = 0;

        // Reverse the digits of x
        while (x != 0) {

            // Get the last digit
            int lastDigit = x % 10;

            // Append it to reversed number
            reversed = reversed * 10 + lastDigit;

            // Remove the last digit from x
            x = x / 10;
        }

        // If original and reversed are same → palindrome
        return original == reversed;
    }
}
