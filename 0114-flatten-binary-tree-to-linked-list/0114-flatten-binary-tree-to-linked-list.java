class Solution {
    // This will keep track of the previously processed node
    // (acts like the "next" pointer in the flattened list)
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        // Base case: if node is null, do nothing
        if (root == null)
            return;

        // IMPORTANT:
        // We process RIGHT first, then LEFT (reverse preorder)
        // Why? Because we are building the linked list from bottom → top
        flatten(root.right);
        flatten(root.left);

        // At this point, 'prev' points to the already flattened part
        // Attach it to current node's right
        root.right = prev;

        // Set left to null as per linked list requirement
        root.left = null;

        // Move prev to current node
        // This node will be used for its parent
        prev = root;
    }
}