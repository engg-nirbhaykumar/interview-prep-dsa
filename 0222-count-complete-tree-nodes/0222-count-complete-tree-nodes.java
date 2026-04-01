class Solution {

    // Function to compute height by going only left
    // This gives the height of the leftmost path
    private int getLeftHeight(TreeNode node) {
        int height = 0;

        // If tree is empty
        if (node == null)
            return 0;

        // Traverse left until null
        while (node != null) {
            node = node.left;
            height++;
        }

        return height;
    }

    // Function to compute height by going only right
    // This gives the height of the rightmost path
    private int getRightHeight(TreeNode node) {
        int height = 0;

        // If tree is empty
        if (node == null)
            return 0;

        // Traverse right until null
        while (node != null) {
            node = node.right;
            height++;
        }

        return height;
    }

    public int countNodes(TreeNode root) {

        // Base case:
        // If current node is null → no nodes
        if (root == null)
            return 0;

        // Get leftmost and rightmost heights
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        // If heights are equal → tree is a PERFECT binary tree
        // Number of nodes = 2^h - 1 (no need to traverse further)
        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        }

        // If not perfect → recursively count nodes
        // Count current node (1) + left subtree + right subtree
        return 1
                + countNodes(root.left) // nodes in left subtree
                + countNodes(root.right); // nodes in right subtree
    }
}