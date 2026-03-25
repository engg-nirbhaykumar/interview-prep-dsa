class Solution {
    
    // List to store preorder traversal result
    List<Integer> result = new ArrayList<>();

    // Helper recursive function
    private void solve(TreeNode root) {
        
        // Base case: if node is null, do nothing
        if (root == null) {
            return;
        }

        // Step 1: Visit root (Preorder → Root, Left, Right)
        result.add(root.val);

        // Step 2: Traverse left subtree
        solve(root.left);

        // Step 3: Traverse right subtree
        solve(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        
        // Start recursive traversal from root
        solve(root);

        // Return final preorder list
        return result;
    }
}