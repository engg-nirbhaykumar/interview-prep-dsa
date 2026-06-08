class Solution {
    public boolean closeStrings(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        // Close strings must have the same length
        if (m != n)
            return false;

        // Frequency arrays for both strings
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count frequency of each character
        for (int i = 0; i < m; i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            freq1[ch1 - 'a']++;
            freq2[ch2 - 'a']++;
        }

        // Check that both strings contain exactly the same set of characters
        // If a character exists in one string but not the other,
        // they can never be transformed into each other
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != 0 && freq2[i] != 0)
                continue;

            if (freq1[i] == 0 && freq2[i] == 0)
                continue;

            return false;
        }

        // Sort frequency arrays so that frequency distributions can be compared
        // Operation 2 allows swapping frequencies between existing characters
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        // Strings are close if they have the same frequency distribution
        return Arrays.equals(freq1, freq2);
    }
}