class Solution {
    
    // Keeps track of how many nodes we've visited so far (in inorder)
    private int count = 0;
    
    // Stores the kth smallest result
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        
        // Perform inorder traversal (Left → Root → Right)
        inorder(root, k);
        
        // After traversal, result will hold the kth smallest element
        return result;
    }

    private void inorder(TreeNode node, int k) {
        
        // Base case: if node is null, return
        if (node == null) return;

        // Traverse left subtree (smaller elements first)
        inorder(node.left, k);

        // Visit current node
        count++;  // Increment count as this node is "visited" in sorted order
        
        // If current node is the kth visited node → this is kth smallest
        if (count == k) {
            result = node.val;
            return; // Stop further unnecessary processing
        }

        // Traverse right subtree (larger elements)
        inorder(node.right, k);
    }
}