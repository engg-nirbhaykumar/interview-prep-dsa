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
    private int idx;
    private Map<Integer, Integer> inIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        idx = n - 1;
        inIndex = new HashMap<>();

        // Build map for quick lookup of inorder indices
        for (int i = 0; i < n; i++) {
            inIndex.put(inorder[i], i);
        }

        return buildTreeRec(postorder, 0, n - 1);
    }

    private TreeNode buildTreeRec(int[] postorder, int start, int end) {
        if (start > end)
            return null;

        // Current root is last unprocessed element in postorder
        int rootVal = postorder[idx--];
        TreeNode root = new TreeNode(rootVal);

        // Get index in inorder array
        int inIdx = inIndex.get(rootVal);

        // Postorder: left → right → root
        // So build right subtree before left subtree
        root.right = buildTreeRec(postorder, inIdx + 1, end);
        root.left = buildTreeRec(postorder, start, inIdx - 1);

        return root;
    }
}