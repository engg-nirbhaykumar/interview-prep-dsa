class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case:
        // 1. If current node is null → no LCA here
        // 2. If current node matches p or q → return it
        //    (this helps bubble up the found node)
        if (root == null || root == p || root == q)
            return root;

        // Recursively search in left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Recursively search in right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null,
        // it means p is found in one subtree and q in the other
        // → current node is the Lowest Common Ancestor
        if (left != null && right != null)
            return root;

        // If only one side is non-null,
        // return that side (it could be p, q, or LCA found deeper)
        return left != null ? left : right;
    }
}