class Solution {

    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int len = 0;  // length of previous longest prefix-suffix
        int i = 1;

        while (i < n) {
            // characters match → extend the prefix-suffix
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            // mismatch after match → fallback using LPS
            else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // lps[n-1] gives length of longest happy prefix
        int longest = lps[n - 1];
        return s.substring(0, longest);
    }
}
