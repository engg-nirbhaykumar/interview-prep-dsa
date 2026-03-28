class Solution {

    // Global variable to track maximum path sum found so far
    private Integer maxSum = Integer.MIN_VALUE;

    // DFS function returns maximum path sum starting from current node
    // (only one side can be chosen when returning to parent)
    private int solve(TreeNode root) {

        // Base case: null node contributes 0
        if (root == null)
            return 0;

        // Recursively compute max path sum from left and right subtrees
        int left = solve(root.left);
        int right = solve(root.right);

        // Case 1: path passes through current node (takes both sides)
        int leftRightRoot = left + right + root.val;

        // Case 2: path includes current node + either left OR right subtree
        int leftOrRightRoot = Math.max(left, right) + root.val;

        // Case 3: path includes only current node
        int rootOnly = root.val;

        // Update global maximum considering all possible cases
        maxSum = Math.max(maxSum,
                Math.max(leftRightRoot, Math.max(leftOrRightRoot, rootOnly)));

        // Return the best path sum going upwards (cannot take both sides)
        // Only one path can be extended to parent
        return Math.max(leftOrRightRoot, rootOnly);
    }

    public int maxPathSum(TreeNode root) {

        // Start DFS traversal
        solve(root);

        // Return the maximum path sum found
        return maxSum;
    }
}