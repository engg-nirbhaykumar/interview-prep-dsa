class Solution {

    // Helper function to find the rightmost node in the left subtree
    // (i.e., inorder predecessor)
    private TreeNode findLeftRightMostLastNode(TreeNode root) {
        // Keep moving right until the last node
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    // This function handles deletion of a node and returns
    // the new subtree root after deletion
    private TreeNode helper(TreeNode root) {

        // Case 1: No left child → return right child directly
        if (root.left == null) {
            return root.right;
        }

        // Case 2: No right child → return left child directly
        else if (root.right == null) {
            return root.left;
        }

        // Case 3: Node has both left and right children

        // Store right subtree
        TreeNode rightChild = root.right;

        // Find the rightmost node in left subtree
        // (largest value in left subtree)
        TreeNode leftRightMostLastNode = findLeftRightMostLastNode(root.left);

        // Attach the original right subtree to that node
        leftRightMostLastNode.right = rightChild;

        // Return left subtree as new root
        return root.left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        // Base case: empty tree
        if (root == null)
            return null;

        // If root itself is the node to delete
        if (root.val == key) {
            return helper(root);
        }

        // Keep reference of original root
        TreeNode curr = root;

        // Traverse the tree to find the node to delete
        while (root != null) {

            // If key is smaller → go left
            if (root.val > key) {

                // If left child is the node to delete
                if (root.left != null && root.left.val == key) {

                    // Delete it using helper and reconnect subtree
                    root.left = helper(root.left);

                } else {
                    // Continue traversal
                    root = root.left;
                }

            } else {
                // If key is greater or equal → go right

                // If right child is the node to delete
                if (root.right != null && root.right.val == key) {

                    // Delete it using helper and reconnect subtree
                    root.right = helper(root.right);

                } else {
                    // Continue traversal
                    root = root.right;
                }
            }
        }

        // Return original root (tree updated in-place)
        return curr;
    }
}