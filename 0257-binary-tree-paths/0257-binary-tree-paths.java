class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // List to store all root-to-leaf paths
        List<String> result = new ArrayList<>();
        
        // Start DFS traversal from root with empty path
        dfs(root, "", result);
        
        return result;
    }

    // Helper function to check if a node is a leaf node
    private boolean isLeaf(TreeNode root) {
        // A leaf node has no left and right children
        return root != null && root.left == null && root.right == null;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        // Base case: if node is null, stop recursion
        if (root == null) {
            return;
        }

        // Build the path string
        // If path is empty → first node (root)
        if (path.isEmpty()) {
            path = String.valueOf(root.val);
        } else {
            // Append current node to existing path
            path = path + "->" + root.val;
        }

        // If current node is a leaf → add path to result
        if (isLeaf(root)) {
            result.add(path);
            return; // stop further traversal
        }

        // Recurse on left subtree
        dfs(root.left, path, result);

        // Recurse on right subtree
        dfs(root.right, path, result);
    }
}