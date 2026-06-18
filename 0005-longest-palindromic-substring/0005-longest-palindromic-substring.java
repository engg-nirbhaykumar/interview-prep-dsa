class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        // If string has length 0 or 1, it is already the longest palindrome
        if (n <= 1)
            return s;

        String longest = "";

        // Check every possible substring s[i...j]
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                // Check if the current substring is a palindrome
                if (isPalindrome(s, i, j)) {

                    // Update longest palindrome if current one is larger
                    if (j - i + 1 > longest.length()) {
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }

        return longest;
    }

    // Helper method to check whether s[left...right] is a palindrome
    private boolean isPalindrome(String s, int left, int right) { 

        // Compare characters from both ends moving inward
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // mismatch found, not a palindrome
            }
            left++;
            right--;
        }

        return true; // all matched, valid palindrome
    }
}
