class Solution {

    public String minWindow(String s, String t) {
        // Edge cases: if s or t is empty, or s is smaller than t
        if (s.isEmpty() || t.isEmpty() || s.length() < t.length())
            return "";

        /*
         * Frequency array for characters in t
         * ASCII size = 256 to cover all possible characters
         */
        int[] tMap = new int[256];
        for (char ch : t.toCharArray()) {
            tMap[ch]++;
        }

        int count = t.length();     // Number of characters still needed
        int minLen = Integer.MAX_VALUE; // Length of minimum valid window found
        int left = 0;               // Left pointer of sliding window
        int startIndex = 0;         // Starting index of minimum window

        // Right pointer expands the window
        for (int right = 0; right < s.length(); right++) {

            /*
             * If current character is needed (frequency > 0),
             * we reduce the remaining required character count
             */
            if (tMap[s.charAt(right)] > 0) {
                count--;
            }

            // Decrease frequency for current character
            tMap[s.charAt(right)]--;

            /*
             * When all characters of t are included in the window (count == 0),
             * try to shrink the window from the left to find minimum length
             */
            while (count == 0) {

                // Update minimum window if current one is smaller
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                // Restore frequency of leftmost character
                tMap[s.charAt(left)]++;

                /*
                 * If frequency becomes positive, it means
                 * we are removing a required character from the window
                 */
                if (tMap[s.charAt(left)] > 0) {
                    count++;
                }

                // Shrink window
                left++;
            }
        }

        // Return result substring or empty string if no valid window found
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}
