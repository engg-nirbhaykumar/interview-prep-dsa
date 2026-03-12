class Solution {

    static class TrieNode {
        TrieNode left; // bit 0
        TrieNode right; // bit 1
    }

    // Insert number into trie
    private void insert(TrieNode root, int num) {
        TrieNode node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (bit == 0) {
                if (node.left == null)
                    node.left = new TrieNode();
                node = node.left;
            } else {
                if (node.right == null)
                    node.right = new TrieNode();
                node = node.right;
            }
        }
    }

    // Find maximum XOR with given number
    private int getMaxXor(TrieNode root, int num) {
        TrieNode node = root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            // try opposite bit for maximum XOR
            if (bit == 0) {
                if (node.right != null) {
                    maxXor += Math.pow(2, i) * 1;
                    node = node.right;
                } else {
                    maxXor += Math.pow(2, i) * 0;
                    node = node.left;
                }
            } else {
                if (node.left != null) {
                    maxXor += Math.pow(2, i) * 1;
                    node = node.left;
                } else {
                    maxXor += Math.pow(2, i) * 0;
                    node = node.right;
                }
            }
        }

        return maxXor;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);

        int q = queries.length;

        // store query as {m, x, index}
        int[][] offlineQueries = new int[q][3];

        for (int i = 0; i < q; i++) {
            offlineQueries[i][0] = queries[i][1]; // m
            offlineQueries[i][1] = queries[i][0]; // x
            offlineQueries[i][2] = i; // original index
        }

        Arrays.sort(offlineQueries, (a, b) -> a[0] - b[0]);

        TrieNode root = new TrieNode();
        int[] result = new int[q];

        int i = 0;

        for (int[] query : offlineQueries) {

            int m = query[0];
            int x = query[1];
            int idx = query[2];

            // insert all nums <= m
            while (i < nums.length && nums[i] <= m) {
                insert(root, nums[i]);
                i++;
            }

            // if no number inserted yet
            if (i == 0) {
                result[idx] = -1;
            } else {
                result[idx] = getMaxXor(root, x);
            }
        }

        return result;
    }
}