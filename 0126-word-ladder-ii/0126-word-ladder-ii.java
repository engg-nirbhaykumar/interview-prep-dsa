class Solution {

    // Step 2: DFS to build all paths
    private void dfs(String word, String beginWord,
                     Map<String, List<String>> parentMap,
                     List<String> path,
                     List<List<String>> result) {

        // If we reached beginWord, reverse path and add to result
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        // If no parent exists, return
        if (!parentMap.containsKey(word)) return;

        // Traverse all parents
        for (String parent : parentMap.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, parentMap, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord not present
        if (!wordSet.contains(endWord)) return result;

        // Step 1: BFS to build parent map
        Map<String, List<String>> parentMap = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            Set<String> levelVisited = new HashSet<>();

            for (int k = 0; k < size; k++) {

                String curr = q.poll();
                char[] arr = curr.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char old = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[i] = ch;
                        String newWord = new String(arr);

                        if (!wordSet.contains(newWord)) continue;

                        // If not visited in previous levels
                        if (!visited.contains(newWord)) {

                            // Add parent mapping
                            parentMap.computeIfAbsent(newWord, x -> new ArrayList<>()).add(curr);

                            // Add to queue only once per level
                            if (!levelVisited.contains(newWord)) {
                                q.offer(newWord);
                                levelVisited.add(newWord);
                            }

                            // If endWord found
                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    arr[i] = old;
                }
            }

            // Mark level visited nodes globally
            visited.addAll(levelVisited);
        }

        // Step 2: DFS to generate paths
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, parentMap, path, result);
        }

        return result;
    }
}