class Solution {
    public int maxDepth(TreeNode root) {

        // Initialize depth to 0
        int depth = 0;

        // Edge case: if tree is empty
        if (root == null)
            return depth;

        // Queue for level order traversal (BFS)
        Queue<TreeNode> q = new LinkedList<>();

        // Start with root node
        q.offer(root);

        // Process level by level
        while (!q.isEmpty()) {

            // Number of nodes at current level
            int levelSize = q.size();

            // Process all nodes of this level
            for (int i = 0; i < levelSize; i++) {

                // Remove node from front of queue
                TreeNode curr = q.poll();

                // Add left child to queue (next level)
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                // Add right child to queue (next level)
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            // After processing one full level, increment depth
            depth++;
        }

        // Final depth = number of levels in tree
        return depth;
    }
}