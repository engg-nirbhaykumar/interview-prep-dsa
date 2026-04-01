class Solution {
    public boolean checkTree(TreeNode root) {

        // If tree is empty, we can consider it valid
        if (root == null) return true;

        // Check if root value equals sum of left and right child values
        // Assumption: root has both left and right children (as per problem constraint)
        return root.val == (root.left.val + root.right.val);
    }
}