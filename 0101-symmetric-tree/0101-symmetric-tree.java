class Solution {
    public boolean isSymmetric(TreeNode root) {

        // Empty tree is always symmetric
        if (root == null) return true;

        // Queue to store pairs of nodes to compare
        Queue<TreeNode> q = new LinkedList<>();

        // Start by adding left and right subtree of root
        q.offer(root.left);
        q.offer(root.right);

        // Process nodes in pairs
        while (!q.isEmpty()) {

            // Take two nodes at a time for comparison
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            // Case 1: both nodes are null -> symmetric at this level
            if (t1 == null && t2 == null) continue;

            // Case 2: one is null, other is not -> not symmetric
            if (t1 == null || t2 == null) return false;

            // Case 3: values mismatch -> not symmetric
            if (t1.val != t2.val) return false;

            // Add children in "mirror order":
            // t1.left should match t2.right
            q.offer(t1.left);
            q.offer(t2.right);

            // t1.right should match t2.left
            q.offer(t1.right);
            q.offer(t2.left);
        }

        // If all comparisons passed, tree is symmetric
        return true;
    }
}