class Trie {

    // Each TrieNode represents a single character
    class TrieNode {

        // Array of children nodes (for 'a' to 'z')
        TrieNode[] children;

        // Marks whether this node completes a valid word
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26]; // 26 lowercase English letters
            isWord = false;              // initially not end of a word
        }
    }

    // Root node of the Trie (empty character)
    private TrieNode root;

    // Initialize Trie with an empty root node
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the Trie
    public void insert(String word) {

        // Start from the root
        TrieNode curr = root;

        // Traverse each character of the word
        for (char ch : word.toCharArray()) {

            // Calculate index for character ('a' -> 0, 'z' -> 25)
            int index = ch - 'a';

            // If the path does not exist, create a new node
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            // Move to the next node
            curr = curr.children[index];
        }

        // Mark the end of the word
        curr.isWord = true;
    }

    // Searches for a complete word in the Trie
    public boolean search(String word) {

        TrieNode curr = root;

        // Traverse the Trie following the word characters
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            // If character path doesn't exist, word is absent
            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        // Word exists only if end marker is true
        return curr.isWord;
    }

    // Checks if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {

        TrieNode curr = root;

        // Traverse the Trie following prefix characters
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            // If path breaks, prefix doesn't exist
            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        // All prefix characters found
        return true;
    }
}
