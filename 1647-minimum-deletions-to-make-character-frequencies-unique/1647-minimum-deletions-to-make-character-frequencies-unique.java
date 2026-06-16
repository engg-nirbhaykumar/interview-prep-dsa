class Solution {
    public int minDeletions(String s) {

        // Store the frequency of each character ('a' to 'z')
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies in ascending order
        // Example: [0, 0, 1, 2, 2, 3]
        Arrays.sort(freq);

        int result = 0;

        // Traverse from right to left (higher frequencies to lower frequencies)
        // Ensure each frequency is strictly less than the frequency on its right
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {

            // Store the original frequency before modification
            int oldVal = freq[i];

            // The maximum allowed value for the current frequency is:
            // (next frequency - 1) to maintain uniqueness
            //
            // Use Math.max(0, ...) because frequencies cannot be negative
            freq[i] = Math.min(freq[i], Math.max(0, freq[i + 1] - 1));
            // Add the number of deletions performed
            result += oldVal - freq[i];
        }

        return result;
    }
}