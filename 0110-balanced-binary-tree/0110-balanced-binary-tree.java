class Solution {

    // Helper function:
    // Returns height of subtree if balanced
    // Returns -1 if subtree is unbalanced
    private int dfs(TreeNode root) {

        // Base case: empty node has height 0
        if (root == null) {
            return 0;
        }

        // Recursively check left subtree
        int left = dfs(root.left);

        // If left subtree is unbalanced, propagate -1 upwards
        if (left == -1)
            return -1;

        // Recursively check right subtree
        int right = dfs(root.right);

        // If right subtree is unbalanced, propagate -1 upwards
        if (right == -1)
            return -1;

        // If current node is unbalanced (height difference > 1)
        if (Math.abs(left - right) > 1)
            return -1;

        // Otherwise, return height of current subtree
        // height = 1 (current node) + max(left, right)
        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {

        // If dfs returns -1 → tree is unbalanced
        // Otherwise → tree is balanced
        return dfs(root) != -1;
    }
}