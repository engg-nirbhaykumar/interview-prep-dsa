class Solution {

    int[] LPS; // Global LPS array

    // -------------------------------------------------------------
    //  Computes the LPS (Longest Prefix Suffix) array for KMP
    // -------------------------------------------------------------
    // LPS[i] = longest proper prefix of pattern[0..i]
    //          which is also a suffix of pattern[0..i]
    //
    // Example: "ababaca"
    // LPS:      0 0 1 2 3 0 1
    // -------------------------------------------------------------
    public void computeLPS(String pattern) {
        int M = pattern.length();
        LPS = new int[M];   // Allocate global LPS array

        int len = 0;        // Length of previous longest prefix suffix
        LPS[0] = 0;         // First value is always 0

        int i = 1;
        while (i < M) {

            // Case 1: characters match → extend prefix-suffix
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                LPS[i] = len;
                i++;
            }

            // Case 2: mismatch after some matching
            else {
                if (len != 0) {
                    // Fallback using previous LPS value
                    len = LPS[len - 1];
                } else {
                    // No prefix matched → set LPS[i] = 0
                    LPS[i] = 0;
                    i++;
                }
            }
        }
    }

    // -------------------------------------------------------------
    //   SHORTEST PALINDROME USING KMP
    // -------------------------------------------------------------
    // Idea:
    //   - To make s a palindrome by adding chars in front,
    //     we want the *longest palindrome starting at index 0*.
    //
    //   - Trick:
    //         s + "-" + reverse(s)
    //
    //   - The LPS of this combined string gives the length of
    //     longest prefix of s which is also a suffix of reverse(s).
    //
    //   - That means: longest prefix of s that forms a palindrome.
    //
    //   - Remaining unmatched part from reverse(s) must be added.
    // -------------------------------------------------------------
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();   // Reverse of s

        String temp = s + "-" + rev;  // Combine with a delimiter (avoids false matches)

        computeLPS(temp);  // Prepare LPS array for combined string

        // LPS[last] contains length of longest palindromic prefix in s
        int longestLPSLength = LPS[temp.length() - 1];

        // Characters from rev that are NOT part of the palindrome prefix in s
        // These characters must be added in front
        String culprit = rev.substring(0, s.length() - longestLPSLength);

        // Add the missing prefix + original string
        return culprit + s;
    }
}
