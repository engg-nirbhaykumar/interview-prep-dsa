class Solution {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> st = new Stack<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        // Clear result in case object is reused
        result.clear();

        TreeNode curr = root;

        // Traverse until all nodes are processed
        while (curr != null || !st.isEmpty()) {

            // Step 1: Push all left nodes
            while (curr != null) {
                st.push(curr); // push current node
                curr = curr.left; // move left
            }

            // Step 2: Process node
            curr = st.pop();
            result.add(curr.val);

            // Step 3: Move to right subtree
            curr = curr.right;
        }

        return result;
    }
}