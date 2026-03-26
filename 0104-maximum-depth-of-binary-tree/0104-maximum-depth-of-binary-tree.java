class Solution {

    // Helper recursive function to calculate depth
    private int solve(TreeNode root) {

        // Base case: if node is null, depth = 0
        if (root == null)
            return 0;

        // Recursively find depth of left subtree
        int left = solve(root.left);

        // Recursively find depth of right subtree
        int right = solve(root.right);

        // Current node depth = 1 (current node)
        // + maximum of left and right subtree depths
        return 1 + Math.max(left, right);
    }

    public int maxDepth(TreeNode root) {
        // Call recursive function starting from root
        return solve(root);
    }
}