class Solution {
    
    // List to store inorder traversal result
    List<Integer> result = new ArrayList<>();

    // Helper recursive function
    private void solve(TreeNode root) {
        
        // Base case: if node is null, stop recursion
        if (root == null) {
            return;
        }

        // Step 1: Traverse left subtree
        solve(root.left);

        // Step 2: Visit root (Inorder → Left, Root, Right)
        result.add(root.val);

        // Step 3: Traverse right subtree
        solve(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        
        // Clear previous results (important if object is reused)
        result.clear();

        // Start recursive traversal from root
        solve(root);

        // Return final inorder list
        return result;
    }
}