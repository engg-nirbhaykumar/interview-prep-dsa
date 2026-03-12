class Solution {

    // Trie node representing a bit (0 or 1)
    static class TrieNode {
        TrieNode left;   // represents bit 0
        TrieNode right;  // represents bit 1
    }

    // Insert a number into the bitwise trie
    private void insert(TrieNode root, int num) {

        TrieNode pCrawl = root;

        // Traverse from MSB (31st bit) to LSB (0th bit)
        for (int i = 31; i >= 0; i--) {

            // Extract ith bit of the number
            int ithBit = (num >> i) & 1;

            // If bit is 0 → go to left child
            if (ithBit == 0) {

                // Create node if it does not exist
                if (pCrawl.left == null) {
                    pCrawl.left = new TrieNode();
                }

                // Move to left
                pCrawl = pCrawl.left;

            } else { // bit = 1 → go to right child

                // Create node if it does not exist
                if (pCrawl.right == null) {
                    pCrawl.right = new TrieNode();
                }

                // Move to right
                pCrawl = pCrawl.right;
            }
        }
    }

    // Find maximum XOR of given number with numbers stored in trie
    private int findMaxXOR(TrieNode root, int num) {

        int maxXor = 0;
        TrieNode pCrawl = root;

        // Traverse bits from MSB to LSB
        for (int i = 31; i >= 0; i--) {

            // Extract ith bit of number
            int ithBit = (num >> i) & 1;

            // If current bit = 1
            if (ithBit == 1) {

                // For maximum XOR we prefer opposite bit (0)
                if (pCrawl.left != null) {

                    // Move to left (0)
                    pCrawl = pCrawl.left;

                    // XOR contribution at this bit = 1
                    maxXor += Math.pow(2, i) * 1;

                } else {

                    // Otherwise move to same bit (1)
                    pCrawl = pCrawl.right;

                    // XOR contribution = 0
                    maxXor += Math.pow(2, i) * 0;
                }

            } else { // current bit = 0

                // Prefer opposite bit (1) for maximum XOR
                if (pCrawl.right != null) {

                    // Move to right
                    pCrawl = pCrawl.right;

                    // XOR contribution = 1
                    maxXor += Math.pow(2, i) * 1;

                } else {

                    // Otherwise move to left
                    pCrawl = pCrawl.left;

                    // XOR contribution = 0
                    maxXor += Math.pow(2, i) * 0;
                }
            }
        }

        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {

        // Create trie root
        TrieNode root = new TrieNode();

        int maxXor = 0;

        // Insert all numbers into trie
        for (int num : nums) {
            insert(root, num);
        }

        // For each number find the best XOR partner
        for (int i = 0; i < nums.length; i++) {

            // Compute max XOR for this number
            maxXor = Math.max(maxXor, findMaxXOR(root, nums[i]));
        }

        return maxXor;
    }
}