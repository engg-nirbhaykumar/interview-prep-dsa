class Solution {

    // Helper function to check if two trees are mirror of each other
    private boolean solve(TreeNode t1, TreeNode t2) {

        // Case 1: both nodes are null -> symmetric
        if (t1 == null && t2 == null)
            return true;

        // Case 2: one is null, other is not -> not symmetric
        if (t1 == null || t2 == null)
            return false;

        // Case 3: values are different -> not symmetric
        if (t1.val != t2.val)
            return false;

        // Core logic:
        // Check mirror condition:
        // left subtree of t1 should match right subtree of t2
        // right subtree of t1 should match left subtree of t2
        return solve(t1.left, t2.right) && solve(t1.right, t2.left);
    }

    public boolean isSymmetric(TreeNode root) {

        // Empty tree is always symmetric
        if (root == null)
            return true;

        // Start checking from left and right subtree of root
        return solve(root.left, root.right);
    }
}