class Solution {

    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        // Fix a starting index for the substring
        for (int i = 0; i < n; i++) {

            // Frequency array for characters in the current substring
            int[] freq = new int[26];

            // Extend the substring from i → j
            for (int j = i; j < n; j++) {

                // Add current character to frequency table
                freq[s.charAt(j) - 'a']++;

                int maxi = Integer.MIN_VALUE;  // maximum frequency of any character
                int mini = Integer.MAX_VALUE;  // minimum frequency among characters that appear

                // Check all 26 characters
                for (int k = 0; k < 26; k++) {
                    int val = freq[k];

                    // Update maximum frequency
                    maxi = Math.max(maxi, val);

                    // Update minimum frequency only for characters that have appeared
                    if (val > 0) {
                        mini = Math.min(mini, val);
                    }
                }

                // Beauty = max freq - min freq for this substring
                sum += maxi - mini;
            }
        }

        return sum;
    }
}