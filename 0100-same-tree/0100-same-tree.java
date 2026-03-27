class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Case 1: both nodes are null → trees match at this position
        if (p == null && q == null)
            return true;

        // Case 2: one node is null and the other is not → structure mismatch
        if (p == null || q == null)
            return false;

        // Case 3: values are different → trees are not same
        if (p.val != q.val)
            return false;

        // Case 4: recursively check left and right subtrees
        // Both must be true for trees to be identical
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}