class Solution {
    // Global variable to store maximum diameter (in terms of edges)
    int diameter = 0;

    // DFS function returns height of subtree
    private int dfs(TreeNode root) {

        // Base case: null node has height 0
        if (root == null)
            return 0;

        // Recursively get height of left subtree
        int left = dfs(root.left);

        // Recursively get height of right subtree
        int right = dfs(root.right);

        // Diameter through current node = left height + right height (edges)
        // ⚠️ IMPORTANT: We must take MAX, not direct assignment
        diameter = Math.max(diameter, left + right);

        // Return height of current subtree to parent
        // height = 1 (current node) + max(left, right)
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // Start DFS traversal
        dfs(root);

        // Return the maximum diameter found
        return diameter;
    }
}