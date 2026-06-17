class Solution {
    public int countBinarySubstrings(String s) {

        // Length of the input string
        int n = s.length();

        // Stores the length of the previous group of consecutive characters
        // Example: in "001110", when processing "111", prev = 2 (length of "00")
        int prev = 0;

        // Stores the length of the current group of consecutive characters
        // Starts with 1 because the first character forms a group of size 1
        int curr = 1;

        // Stores the total number of valid binary substrings
        int result = 0;

        // Traverse the string starting from the second character
        for (int i = 1; i < n; i++) {

            // If current character is the same as the previous one,
            // extend the current group length
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {

                // Group boundary found
                // Number of valid substrings formed between the previous
                // and current groups is the minimum of their lengths
                result += Math.min(prev, curr);

                // Update previous group length to current group length
                prev = curr;

                // Reset current group length for the new character group
                curr = 1;
            }
        }

        // Add the contribution of the last pair of groups
        return result + Math.min(prev, curr);
    }
}