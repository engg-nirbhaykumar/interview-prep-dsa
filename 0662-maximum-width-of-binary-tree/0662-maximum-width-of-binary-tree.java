class Solution {

    // Helper class to store a node along with its index
    static class Pair {
        TreeNode node; // current node
        long index; // position index (as in complete binary tree)

        public Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // Edge case: empty tree
        if (root == null)
            return 0;

        // Stores maximum width found so far
        long maxWidth = Long.MIN_VALUE;

        // Deque to perform BFS (level order traversal)
        Deque<Pair> q = new LinkedList<>();

        // Start with root node at index 0
        q.add(new Pair(root, 0));

        // Perform level order traversal
        while (!q.isEmpty()) {

            // Number of nodes at current level
            int levelSize = q.size();

            // Get indices of first and last node in this level
            long l = q.peekFirst().index;
            long r = q.peekLast().index;

            // Width of current level = last - first + 1
            maxWidth = Math.max(maxWidth, r - l + 1);

            // Process all nodes in current level
            for (int i = 0; i < levelSize; i++) {
                Pair pair = q.poll();

                TreeNode node = pair.node;
                long index = pair.index;

                // Add left child with index: 2*i + 1
                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * index + 1));
                }

                // Add right child with index: 2*i + 2
                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * index + 2));
                }
            }
        }

        // Return maximum width (cast to int as per problem)
        return (int) maxWidth;
    }
}