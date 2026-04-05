class Solution {

    // Pointer to track current index in preorder array
    private int i = 0;

    private TreeNode solve(int[] preorder, int min, int max) {

        // If all elements are processed → no node to create
        if (i >= preorder.length)
            return null;

        int val = preorder[i]; // Peek current value (do NOT increment yet)

        // If value is out of valid BST range → it doesn't belong here
        // Important: do NOT consume it (do not increment i)
        if (val < min || val > max)
            return null;

        // Now value is valid → consume it
        i++;

        // Create current node
        TreeNode root = new TreeNode(val);

        // Build left subtree:
        // All values must be less than current node value
        root.left = solve(preorder, min, val);

        // Build right subtree:
        // All values must be greater than current node value
        root.right = solve(preorder, val, max);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        // Reset pointer (important if method is reused)
        i = 0;

        // Start with full valid range
        return solve(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}