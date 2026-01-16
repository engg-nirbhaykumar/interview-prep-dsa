class Solution {
    public int numberOfSubstrings(String s) {

        // Frequency array to count occurrences of 'a', 'b', and 'c'
        // freq[0] -> 'a', freq[1] -> 'b', freq[2] -> 'c'
        int[] freq = new int[26];

        // Left pointer of sliding window
        int i = 0;

        int n = s.length();

        // Stores the total count of valid substrings
        int count = 0;

        // Right pointer of sliding window
        for (int j = 0; j < n; j++) {

            // Include current character in the window
            char ch = s.charAt(j);
            freq[ch - 'a']++;

            // While window contains at least one 'a', 'b', and 'c'
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                /*
                 * If substring [i..j] is valid, then
                 * all substrings [i..j], [i..j+1], ..., [i..n-1]
                 * will also be valid.
                 */
                count += n - j;

                // Shrink window from the left
                freq[s.charAt(i) - 'a']--;
                i++;
            }
        }

        // Return total number of valid substrings
        return count;
    }
}
