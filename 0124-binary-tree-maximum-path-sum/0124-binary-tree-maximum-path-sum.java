/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Integer maxSum = Integer.MIN_VALUE;

    private int solve(TreeNode root) {
        if (root == null)
            return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int leftRightRoot = left + right + root.val;

        int leftOrRightRoot = Math.max(left, right) + root.val;

        int rootOnly = root.val;

        maxSum = Math.max(maxSum,
                Math.max(leftRightRoot, Math.max(leftOrRightRoot, rootOnly)));

        return Math.max(leftOrRightRoot, rootOnly);
    }

    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
}