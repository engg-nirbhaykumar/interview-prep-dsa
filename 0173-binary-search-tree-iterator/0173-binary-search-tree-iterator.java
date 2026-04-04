class BSTIterator {

    // Stack to simulate recursion (inorder traversal)
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {

        // Initialize stack
        st = new Stack<>();

        // Push all left nodes from root
        // This ensures the smallest element is on top
        pushLeft(root);
    }

    // Helper function: push all left nodes of a subtree
    private void pushLeft(TreeNode node) {

        // Keep moving left and push nodes into stack
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
    
    // Returns the next smallest element in BST
    public int next() {

        // The top of stack is always the next smallest element
        TreeNode smallest = st.pop();

        // After visiting a node, we need to process its right subtree
        // Push all left nodes of right subtree
        pushLeft(smallest.right);

        // Return the value of current node
        return smallest.val;
    }
    
    // Returns true if there are still elements left to iterate
    public boolean hasNext() {

        // If stack is not empty, we still have nodes to process
        return !st.isEmpty();
    }
}