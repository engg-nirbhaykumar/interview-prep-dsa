class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        // List to store the final right view
        List<Integer> result = new ArrayList<>();

        // Edge case: empty tree
        if (root == null)
            return result;

        // Queue for level order traversal (BFS)
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Traverse level by level
        while (!q.isEmpty()) {

            int levelSize = q.size(); // number of nodes in current level

            // Process all nodes in current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();

                // If it's the last node of this level,
                // it will be visible from the right side
                if (i == levelSize - 1) {
                    result.add(curr.val);
                }

                // Add children for next level
                // Left is added first, so rightmost will be last in level
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }

        return result;
    }
}