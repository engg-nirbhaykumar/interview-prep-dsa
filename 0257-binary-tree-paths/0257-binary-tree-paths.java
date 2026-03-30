class Solution {

    // Helper class to store a node along with its path
    static class NodePath {
        private TreeNode node; // current tree node
        private String path; // path from root to this node

        public NodePath(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        // List to store all root-to-leaf paths
        List<String> result = new ArrayList<>();

        // Edge case: empty tree
        if (root == null)
            return result;

        // Queue for BFS traversal
        Queue<NodePath> q = new LinkedList<>();

        // Start with root node and its value as initial path
        q.offer(new NodePath(root, String.valueOf(root.val)));

        // Perform BFS
        while (!q.isEmpty()) {
            // Get current node-path pair
            NodePath nodepath = q.poll();

            // If it's a leaf node → add path to result
            if (nodepath.node.left == null && nodepath.node.right == null) {
                result.add(nodepath.path);
            }

            // If left child exists → add to queue with updated path
            if (nodepath.node.left != null) {
                q.offer(new NodePath(
                        nodepath.node.left,
                        nodepath.path + "->" + nodepath.node.left.val));
            }

            // If right child exists → add to queue with updated path
            if (nodepath.node.right != null) {
                q.offer(new NodePath(
                        nodepath.node.right,
                        nodepath.path + "->" + nodepath.node.right.val));
            }
        }

        // Return all collected paths
        return result;
    }
}