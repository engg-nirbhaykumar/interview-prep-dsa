class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        // Map each character to a queue of strings that are currently waiting for that character
        Map<Character, Queue<String>> map = new HashMap<>();
        int ans = 0; // Final answer: number of matching subsequences

        // Initialize the map with empty queues for all characters that appear in S
        for (int i = 0; i < S.length(); i++) {
            map.putIfAbsent(S.charAt(i), new LinkedList<>());
        }

        // Distribute all words into queues based on their first character
        for (String word : words) {
            char startChar = word.charAt(0);
            if (map.containsKey(startChar)) {
                // Only add the word if its first character appears in S
                map.get(startChar).offer(word);
            }
        }

        // Iterate through the string S
        for (int i = 0; i < S.length(); i++) {
            char startChar = S.charAt(i);

            // Get the queue of words waiting for the current character
            Queue<String> q = map.get(startChar);
            int size = q.size(); // Fix the size since we'll be modifying the queue inside the loop

            // Process all words currently waiting for this character
            for (int k = 0; k < size; k++) {
                String str = q.poll(); // Get the word
                String remaining = str.substring(1); // Remove the matched character

                if (remaining.length() == 0) {
                    // If no characters are left, it's a match!
                    ans++;
                } else {
                    // Otherwise, move the remaining word to the queue of its next required character
                    char nextChar = remaining.charAt(0);
                    if (map.containsKey(nextChar)) {
                        map.get(nextChar).offer(remaining);
                    }
                }
            }
        }

        return ans;
    }
}
