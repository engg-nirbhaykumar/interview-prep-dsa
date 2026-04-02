class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        // If tree is empty, value cannot be found
        if (root == null)
            return null;

        // Traverse the tree iteratively
        while (root != null) {

            // If current node value is greater than target,
            // move to left subtree (smaller values)
            if (root.val > val) {
                root = root.left;

                // If current node value is smaller than target,
                // move to right subtree (larger values)
            } else if (root.val < val) {
                root = root.right;

                // If value matches, return current node
            } else {
                return root;
            }
        }

        // If we reach here, value was not found in BST
        return null;
    }
}