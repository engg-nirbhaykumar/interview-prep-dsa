class Solution {
    public int lengthOfLastWord(String s) {

        // Start from the last character of the string
        int i = s.length() - 1;

        // Skip all trailing spaces at the end
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the length of the last word
        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        // Return the length of the last word
        return length;
    }
}