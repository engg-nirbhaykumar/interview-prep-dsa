class Solution {
    public int longestPalindrome(String s) {

        // Stores characters with odd frequencies seen so far
        Set<Character> seen = new HashSet<>();

        // Length of the longest palindrome that can be formed
        int length = 0;

        for (char ch : s.toCharArray()) {

            // If character is already present,
            // we found a pair and can use both characters
            if (seen.contains(ch)) {
                seen.remove(ch);
                length += 2;
            } else {
                // First occurrence (or currently odd count)
                seen.add(ch);
            }
        }

        // If any character is left with an odd frequency,
        // one of them can be placed in the center of the palindrome
        if (!seen.isEmpty()) {
            length += 1;
        }

        return length;
    }
}