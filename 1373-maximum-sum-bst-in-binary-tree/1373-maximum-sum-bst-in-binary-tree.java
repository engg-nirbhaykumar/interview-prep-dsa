class Solution {

    // Global variable to store the maximum sum of any BST found so far
    private static int maxBstSum = 0;

    // Helper class to store information about each subtree
    static class Info {
        private int sum; // Sum of the subtree (valid only if it's a BST)
        private int min; // Minimum value in the subtree
        private int max; // Maximum value in the subtree
        private boolean isBST; // Whether the subtree is a BST

        public Info(int sum, int min, int max, boolean isBST) {
            this.sum = sum;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    private static Info solve(TreeNode root) {

        // Base case:
        // An empty tree is a valid BST with:
        // sum = 0, min = +∞, max = -∞
        if (root == null) {
            return new Info(
                    0,
                    Integer.MAX_VALUE, // ensures parent comparison works
                    Integer.MIN_VALUE,
                    true);
        }

        // Recursively process left and right subtrees (postorder traversal)
        Info left = solve(root.left);
        Info right = solve(root.right);

        // Check if current subtree forms a valid BST
        if (left.isBST && right.isBST &&
                root.val > left.max && root.val < right.min) {

            // Current subtree is a BST → compute its sum
            int bstSum = root.val + left.sum + right.sum;

            // Update global maximum sum
            maxBstSum = Math.max(maxBstSum, bstSum);

            // Return updated info for this valid BST
            return new Info(
                    bstSum,
                    Math.min(left.min, root.val), // update minimum value
                    Math.max(right.max, root.val), // update maximum value
                    true);
        }

        // If NOT a BST:
        // - We should NOT use its sum (invalid)
        // - Return sum = 0 so parent doesn't include it
        // - Set min/max in a way that breaks parent BST condition
        return new Info(
                0, // invalid BST → no contribution
                Integer.MIN_VALUE, // poison value to fail parent check
                Integer.MAX_VALUE,
                false);
    }

    public int maxSumBST(TreeNode root) {

        // Reset global variable (important for multiple test cases)
        maxBstSum = 0;

        // Start postorder traversal
        solve(root);

        // Return maximum BST sum found
        return maxBstSum;
    }
}