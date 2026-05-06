class Solution {

    public int longestStrChain(String[] words) {
        int n = words.length;

        // Sort words based on length (smallest to largest)
        // So when processing current word,
        // all possible predecessors are already processed
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // dp[i] = longest chain ending at words[i]
        int[] dp = new int[n];

        // Every single word itself forms chain of length 1
        Arrays.fill(dp, 1);

        int maxLen = 1;

        // Try every word as current ending word
        for (int i = 1; i < n; i++) {

            // Check all previous smaller words
            for (int j = 0; j < i; j++) {

                // If words[j] can become words[i]
                // by inserting exactly one character
                if (predecessor(words[j], words[i])) {

                    // Extend chain
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // Update global maximum chain length
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    // Check if prev is predecessor of curr
    // Means curr has exactly one extra character
    // Example:
    // prev = "abc"
    // curr = "abac"
    public boolean predecessor(String prev, String curr) {

        int M = prev.length();
        int N = curr.length();

        // curr must be exactly one character longer
        if (M >= N || N - M != 1)
            return false;

        int i = 0; // pointer for prev
        int j = 0; // pointer for curr

        while (i < M && j < N) {

            // Matching character found
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }

            // Always move curr pointer
            // allows skipping one extra char in curr
            j++;
        }

        // If all chars of prev matched,
        // prev is valid predecessor
        return i == M;
    }
}