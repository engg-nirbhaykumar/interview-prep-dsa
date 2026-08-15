class Solution {

    // dp[i] stores whether substring starting from index i can be segmented
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {

        // Memoization array: one state per starting index
        dp = new Boolean[s.length()];

        // Convert list to HashSet for O(1) lookups
        return dfs(0, s, new HashSet<>(wordDict));
    }

    private boolean dfs(int start, String s, Set<String> wordSet) {

        // Base case:
        // If we reached the end of string, segmentation succeeded
        if (start == s.length()) {
            return true;
        }

        // If this state already computed, return stored result
        if (dp[start] != null)
            return dp[start];

        // Try every possible substring starting at 'start'
        for (int end = start + 1; end <= s.length(); end++) {

            // Extract substring
            String word = s.substring(start, end);

            // If substring exists in dictionary
            // AND remaining string can also be segmented
            if (wordSet.contains(word) && dfs(end, s, wordSet)) {
                return dp[start] = true; // store and return
            }
        }

        // If no segmentation worked
        return dp[start] = false; 
    }
}
