class Solution {

    // Map to store value -> index in inorder array
    // This helps us find root position in O(1)
    private Map<Integer, Integer> inOrderMap;

    // Pointer to track current root in preorder array
    private int preIndex = 0;

    // Recursive function to build tree
    private TreeNode build(int[] preorder, int inStart, int inEnd) {

        // Base case: no elements to construct subtree
        if (inStart > inEnd)
            return null;

        // Step 1: Pick current root from preorder using preIndex
        int rootVal = preorder[preIndex++];

        // Create the root node
        TreeNode root = new TreeNode(rootVal);

        // Step 2: Find root index in inorder array
        int inIndex = inOrderMap.get(rootVal);

        // Step 3:
        // Build LEFT subtree using elements before root in inorder
        root.left = build(preorder, inStart, inIndex - 1);

        // Step 4:
        // Build RIGHT subtree using elements after root in inorder
        root.right = build(preorder, inIndex + 1, inEnd);

        // Return constructed subtree root
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Initialize hashmap for quick lookup of inorder indices
        inOrderMap = new HashMap<>();

        int n = inorder.length;

        // Fill the map: value -> index
        for (int i = 0; i < n; i++) {
            inOrderMap.put(inorder[i], i);
        }

        // Start recursion with full inorder range
        return build(preorder, 0, n - 1);
    }
}