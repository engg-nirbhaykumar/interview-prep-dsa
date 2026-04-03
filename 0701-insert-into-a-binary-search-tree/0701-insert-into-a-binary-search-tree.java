class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        // Base case:
        // If tree is empty, create a new node and return it as root
        if (root == null)
            return new TreeNode(val);

        // Start traversal from root
        TreeNode curr = root;

        // Iterate until we find the correct position to insert
        while (true) {

            // If current node value is <= val, move to right subtree
            // (Because in BST, right subtree contains greater or equal values)
            if (curr.val <= val) {

                // If right child exists, continue traversal
                if (curr.right != null)
                    curr = curr.right;

                else {
                    // Found correct position → insert new node here
                    curr.right = new TreeNode(val);
                    break; // Exit loop after insertion
                }

            } else {
                // If current node value is > val, move to left subtree
                // (Because left subtree contains smaller values)

                // If left child exists, continue traversal
                if (curr.left != null)
                    curr = curr.left;

                else {
                    // Found correct position → insert new node here
                    curr.left = new TreeNode(val);
                    break; // Exit loop after insertion
                }
            }
        }

        // Return the original root (tree is modified in-place)
        return root;
    }
}