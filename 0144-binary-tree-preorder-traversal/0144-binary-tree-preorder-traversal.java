class Solution {
    
    // Stack to simulate recursion
    Stack<TreeNode> st = new Stack<>();
    
    // List to store preorder traversal result
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        
        // Edge case: if tree is empty, return empty list
        if (root == null)
            return result;

        // Step 1: Push root node onto stack
        st.push(root);

        // Process until stack becomes empty
        while (!st.isEmpty()) {
            
            // Step 2: Pop current node
            TreeNode curr = st.pop();
            
            // Step 3: Visit node (Preorder → Root, Left, Right)
            result.add(curr.val);

            // Step 4: Push right child first
            // (so that left is processed first due to stack LIFO)
            if (curr.right != null) {
                st.push(curr.right);
            }

            // Step 5: Push left child
            if (curr.left != null) {
                st.push(curr.left);
            }
        }

        // Return final preorder traversal
        return result;
    }
}