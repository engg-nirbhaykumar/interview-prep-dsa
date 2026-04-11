class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Step 1: Put all words into a set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord is not present, transformation is impossible
        if (!wordSet.contains(endWord))
            return 0;

        // Step 2: BFS queue
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        // Visited set to avoid revisiting words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // Level represents number of transformations
        int level = 1;

        // Step 3: BFS traversal
        while (!q.isEmpty()) {

            int size = q.size();

            // Process all words at current level
            while (size-- > 0) {

                String curr = q.poll();

                // If we reached endWord, return number of steps
                if (endWord.equals(curr))
                    return level;

                // Convert current word to char array for modification
                char[] currArr = curr.toCharArray();

                // Try changing each character
                for (int i = 0; i < currArr.length; i++) {

                    char oldCh = currArr[i]; // store original character

                    // Replace with all possible lowercase letters
                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        currArr[i] = ch;

                        String newWord = new String(currArr);

                        // If new word exists in dictionary and not visited
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {

                            // Add to queue for next level
                            q.offer(newWord);

                            // Mark as visited
                            visited.add(newWord);
                        }
                    }

                    // Restore original character before moving to next index
                    currArr[i] = oldCh;
                }
            }

            // Increment level after processing one full layer
            level++;
        }

        // If endWord not reached, return 0 (no transformation possible)
        return 0;
    }
}