class Solution {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Characters match, continue checking
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Try deleting either left or right character
                return isPalindrome(s, left + 1, right) ||
                       isPalindrome(s, left, right - 1);
            }
        }

        return true;
    }

    // Checks if substring s[left...right] is a palindrome
    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}