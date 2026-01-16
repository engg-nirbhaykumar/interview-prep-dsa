class Solution {
    public int characterReplacement(String s, int k) {
        // Frequency array to store count of characters in current window
        int[] freq = new int[26];

        int maxLen = 0;     // Stores maximum valid window length
        int maxFreq = 0;    // Stores frequency of most common character in current window
        int left = 0;       // Left pointer of sliding window
        int n = s.length();

        // Right pointer expands the window
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            // Include current character in window
            freq[ch - 'A']++;

            // Update max frequency of any character in the current window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            /*
             * If characters to be replaced exceed k,
             * shrink the window from the left
             *
             * Characters to replace = window size - maxFreq
             */
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--; // Remove left character from window
                left++;                        // Shrink window
            }

            // Update maximum valid window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
