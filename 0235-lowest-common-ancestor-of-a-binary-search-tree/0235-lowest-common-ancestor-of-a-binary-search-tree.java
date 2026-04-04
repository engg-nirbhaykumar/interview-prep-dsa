class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Start traversal from root
        TreeNode curr = root;

        // Traverse until we find LCA
        while (curr != null) {

            // Case 1: Both nodes lie in left subtree
            // (p and q are smaller than current node)
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left; // move left
            }

            // Case 2: Both nodes lie in right subtree
            // (p and q are greater than current node)
            else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right; // move right
            }

            // Case 3: Found LCA
            else {
                return curr;
            }
        }

        // Edge case: if not found (should not happen if both nodes exist)
        return null;
    }
}