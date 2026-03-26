class Solution {
    // This list will store the final postorder traversal result
    List<Integer> result = new ArrayList<>();

    // Helper recursive function to perform postorder traversal
    private void solve(TreeNode root) {
        // Base case: if node is null, simply return
        if (root == null) {
            return;
        }

        // Step 1: Traverse the left subtree
        solve(root.left);

        // Step 2: Traverse the right subtree
        solve(root.right);

        // Step 3: Process the current node (add value to result)
        // This is why it's called POST-order (Left -> Right -> Root)
        result.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // Call the recursive helper function starting from root
        solve(root);

        // Return the final postorder traversal list
        return result;
    }
}