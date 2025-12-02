class Solution {

    public int repeatedStringMatch(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        // Minimum repeats needed so that length(a * n) >= length(b)
        // Equivalent to: n = ceil(lenB / lenA)
        int n = (lenB + lenA - 1) / lenA;

        StringBuilder sb = new StringBuilder();

        // We check n, n+1, and n+2 repeats.
        // WHY?
        // Because b can start at the boundary of a and spill over into the next repeated block.
        // Maximum spillover case happens within n + 2 blocks.
        for (int i = 0; i < n + 3; i++) {

            // Build a repeated string
            if (i > 0) sb.append(a);

            // Only start checking once we reach n repeats
            if (i >= n) {
                if (kmpSearch(b, sb.toString())) {
                    return i;  // Found pattern after i repetitions
                }
            }
        }

        return -1; // Pattern never found
    }

    // --------------------------------------------------------
    //                 KMP SEARCH (Pattern in Text)
    // --------------------------------------------------------
    private boolean kmpSearch(String pat, String txt) {
        int N = txt.length();
        int M = pat.length();

        // Build LPS table for the pattern
        int[] lps = computeLPS(pat);

        int i = 0; // pointer for txt
        int j = 0; // pointer for pat

        // Iterate through the text
        while (i < N) {

            // Characters match -> move both pointers
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            // Full pattern matched
            if (j == M) {
                return true; // pattern found
            }

            // Mismatch case
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {

                // If partial match existed, fallback using LPS
                if (j != 0) {
                    j = lps[j - 1];
                }
                // No prefix matched → just move forward in text
                else {
                    i++;
                }
            }
        }

        return false; // pattern not found
    }

    // --------------------------------------------------------
    //                 BUILD LPS ARRAY
    // LPS[i] = longest prefix of pattern which is also suffix
    // --------------------------------------------------------
    private int[] computeLPS(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];

        int len = 0;  // length of current longest prefix-suffix
        int i = 1;

        while (i < M) {

            // Case 1: characters match → extend prefix-suffix
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            // Case 2: mismatch
            else {
                if (len != 0) {
                    // fallback using previous LPS
                    len = lps[len - 1];
                } else {
                    // No prefix matched → assign 0
                    lps[i] = 0;
                    len = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
