class Solution {
    // One-Line Memory Trick
    // Queue → add + poll (FIFO)
    // Stack → push + pop (LIFO)

    // LinkedList used so we can efficiently add at front (addFirst)
    LinkedList<Integer> result;

    // Deque used as a stack
    Deque<TreeNode> st;

    public List<Integer> postorderTraversal(TreeNode root) {
        result = new LinkedList<>();
        st = new LinkedList<>();

        // Edge case: empty tree
        if (root == null)
            return result;

        // Start with root node
        st.push(root);

        while (!st.isEmpty()) {
            // Pop the top node (LIFO)
            TreeNode curr = st.pop();

            // Add current node at the beginning
            // This reverses the order to achieve postorder
            result.addFirst(curr.val);

            // IMPORTANT:
            // Push left first, then right
            // So that right is processed before left (due to stack)
            // Final order becomes: Left → Right → Root
            if (curr.left != null) {
                st.push(curr.left);
            }

            if (curr.right != null) {
                st.push(curr.right);
            }
        }

        // Return the final postorder traversal
        return result;
    }
}