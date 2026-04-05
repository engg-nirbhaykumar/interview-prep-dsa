class Solution {

    // These pointers help identify the two swapped nodes
    private TreeNode first; // first incorrect node
    private TreeNode middle; // middle node (used if adjacent swap)
    private TreeNode last; // second incorrect node (used if non-adjacent swap)
    private TreeNode prev; // previously visited node in inorder traversal

    private void solve(TreeNode root) {
        // Base case
        if (root == null)
            return;

        // Step 1: Traverse left subtree (inorder: left → root → right)
        solve(root.left);

        // Step 2: Detect violation of BST property
        // Inorder traversal of BST should be sorted
        // If current node is smaller than previous → violation
        if (first == null && root.val < prev.val) {
            // First violation:
            // mark previous node as 'first'
            // mark current node as 'middle'
            first = prev;
            middle = root;
        } else if (first != null && root.val < prev.val) {
            // Second violation:
            // mark current node as 'last'
            last = root;
        }

        // Step 3: Update prev to current node
        // (important: must be after processing current node)
        prev = root;

        // Step 4: Traverse right subtree
        solve(root.right);
    }

    public void recoverTree(TreeNode root) {

        // Initialize pointers
        first = null;
        middle = null;
        last = null;

        // Initialize prev with very small value
        // (acts as starting point for inorder comparison)
        prev = new TreeNode(Integer.MIN_VALUE);

        // Perform inorder traversal to detect swapped nodes
        solve(root);

        // Case 1: Non-adjacent nodes swapped
        // Example: 1 5 3 4 2 6
        if (first != null && last != null) {
            int val = first.val;
            first.val = last.val;
            last.val = val;
        }

        // Case 2: Adjacent nodes swapped
        // Example: 1 3 2 4 5
        else if (first != null && middle != null) {
            int val = first.val;
            first.val = middle.val;
            middle.val = val;
        }
    }
}