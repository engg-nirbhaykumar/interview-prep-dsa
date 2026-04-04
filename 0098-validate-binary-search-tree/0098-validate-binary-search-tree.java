class Solution {

    // Recursive helper function to validate BST
    // min → lower bound (all nodes must be > min)
    // max → upper bound (all nodes must be < max)
    private boolean isValidBSTRec(TreeNode node, Integer min, Integer max) {

        // Base case: empty node is valid
        if (node == null)
            return true;

        // Violation check:
        // If current node is not within valid range → not a BST
        if ((min != null && node.val <= min) || 
            (max != null && node.val >= max)) {
            return false;
        }

        // Recursively validate:
        // Left subtree → values must be < current node value
        // Right subtree → values must be > current node value
        return isValidBSTRec(node.left, min, node.val) &&
               isValidBSTRec(node.right, node.val, max);
    }

    public boolean isValidBST(TreeNode root) {

        // Start with no bounds (entire integer range allowed)
        return isValidBSTRec(root, null, null);
    }
}