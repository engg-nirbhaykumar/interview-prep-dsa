class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Final result list storing all levels
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: empty tree
        if (root == null)
            return result;

        // Queue for BFS traversal (level order)
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Flag to control direction of traversal
        // true  -> left to right
        // false -> right to left
        boolean leftToRight = true;

        // Standard BFS loop
        while (!q.isEmpty()) {
            int levelSize = q.size(); // number of nodes at current level
            
            // LinkedList used because we need O(1) insert at both ends
            LinkedList<Integer> level = new LinkedList<>();

            // Process all nodes of current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll(); // remove node from queue

                // Depending on direction, insert accordingly
                if (leftToRight) {
                    level.addLast(curr.val);   // normal order
                } else {
                    level.addFirst(curr.val);  // reverse order
                }

                // Add child nodes to queue for next level
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            // Flip direction for next level (zigzag effect)
            leftToRight = !leftToRight;

            // Add current level to result
            result.add(level);
        }

        return result;
    }
}