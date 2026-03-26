class Solution {
    // This will store final result: list of levels
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();

        // Edge case: if tree is empty
        if (root == null)
            return result;

        // Queue for BFS traversal (FIFO)
        Queue<TreeNode> q = new LinkedList<>();

        // Start with root node
        q.offer(root);

        // Process until queue becomes empty
        while (!q.isEmpty()) {

            // Number of nodes at current level
            int levelSize = q.size();

            // List to store current level values
            List<Integer> level = new ArrayList<>();

            // Process all nodes of current level
            for (int i = 0; i < levelSize; i++) {

                // Remove node from front of queue
                TreeNode curr = q.poll();

                // Add its value to current level list
                level.add(curr.val);

                // Add left child to queue (for next level)
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                // Add right child to queue (for next level)
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            // Add current level list to final result
            result.add(level);
        }

        // Return level-wise traversal
        return result;
    }
}