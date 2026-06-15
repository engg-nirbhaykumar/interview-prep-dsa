class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Track seen characters for prefix and suffix
        Set<Character> seenPrefix = new HashSet<>();
        Set<Character> seenSuffix = new HashSet<>();

        // Prefix: count unique chars from left to right
        for (int i = 0; i < n; i++) {
            seenPrefix.add(s.charAt(i));
            prefix[i] = seenPrefix.size();
        }

        // Suffix: count unique chars from right to left
        for (int i = n - 1; i >= 0; i--) {
            seenSuffix.add(s.charAt(i));
            suffix[i] = seenSuffix.size();
        }

        // Count good splits
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (prefix[i - 1] == suffix[i]) {
                count++;
            }
        }

        return count;
    }
}
