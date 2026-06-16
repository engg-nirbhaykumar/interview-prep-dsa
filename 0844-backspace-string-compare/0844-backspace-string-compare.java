class Solution {
    public boolean backspaceCompare(String s, String t) {

        int n = s.length();
        int m = t.length();

        // Start from the end of both strings
        int i = n - 1;
        int j = m - 1;

        // Number of characters to skip because of backspaces
        int skipS = 0;
        int skipT = 0;

        // Continue until both strings are fully processed
        while (i >= 0 || j >= 0) {

            // Find the next valid character in s
            while (i >= 0) {

                // Current character is a backspace
                if (s.charAt(i) == '#') {
                    skipS++; // Increase skip count
                    i--;
                }

                // Skip the current character if there are pending backspaces
                else if (skipS > 0) {
                    skipS--;
                    i--;
                }

                // Found a valid character to compare
                else {
                    break;
                }
            }

            // Find the next valid character in t
            while (j >= 0) {

                // Current character is a backspace
                if (t.charAt(j) == '#') {
                    skipT++; // Increase skip count
                    j--;
                }

                // Skip the current character if there are pending backspaces
                else if (skipT > 0) {
                    skipT--;
                    j--;
                }

                // Found a valid character to compare
                else {
                    break;
                }
            }

            // Get the current valid characters
            // Use a dummy value when the pointer goes out of bounds
            char first = (i < 0) ? '$' : s.charAt(i);
            char second = (j < 0) ? '$' : t.charAt(j);

            // If characters differ, strings are not equal
            if (first != second) {
                return false;
            }

            // Move to the previous character in both strings
            i--;
            j--;
        }

        // All valid characters matched
        return true;
    }
}