class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        // If needle is empty, by definition return 0
        if (n == 0) return 0;

        // Loop through haystack only until there's enough space for needle
        for (int i = 0; i <= m - n; i++) {

            // Extract substring of length 'n' and compare with needle
            // substring(i, i+n) → takes characters from index i to i+n-1
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;  // Found the starting index of needle in haystack
            }
        }

        // Needle not found in haystack
        return -1;
    }
}
