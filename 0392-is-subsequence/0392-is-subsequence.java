class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int j = 0; // Pointer for string s (subsequence)

        for (int i = 0; i < m && j < n; i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++; // Move subsequence pointer only when characters match
            }
        }

        return j == n; // All characters of s should match in order
    }
}