class Solution {

    // BST Iterator that can traverse:
    // forward (inorder → smallest to largest)
    // reverse (reverse inorder → largest to smallest)
    public class BSTIterator {

        public Stack<TreeNode> st;
        private boolean reverse;

        public BSTIterator(TreeNode node, boolean reverse) {

            // Initialize stack
            st = new Stack<>();

            // Direction of traversal
            this.reverse = reverse;

            // Push initial path (leftmost or rightmost)
            pushAll(node);
        }

        // Push all nodes in one direction:
        // normal → go left (smallest first)
        // reverse → go right (largest first)
        public void pushAll(TreeNode node) {
            while (node != null) {
                st.push(node);

                if (reverse) {
                    node = node.right;  // go towards larger values
                } else {
                    node = node.left;   // go towards smaller values
                }
            }
        }

        // Returns next element based on traversal direction
        public int next() {

            // Get current node
            TreeNode node = st.pop();

            // If reverse → process left subtree next
            // If normal → process right subtree next
            if (reverse) {
                pushAll(node.left);
            } else {
                pushAll(node.right);
            }

            return node.val;
        }
    }

    public boolean findTarget(TreeNode root, int k) {

        // Iterator for smallest values
        BSTIterator left = new BSTIterator(root, false);

        // Iterator for largest values
        BSTIterator right = new BSTIterator(root, true);

        // Initialize two pointers
        int i = left.next();   // smallest
        int j = right.next();  // largest

        // Two pointer approach
        while (i < j) {

            int sum = i + j;

            // If pair found
            if (sum == k)
                return true;

            // If sum is smaller → move left pointer forward
            else if (sum < k) {
                i = left.next();
            }

            // If sum is larger → move right pointer backward
            else {
                j = right.next(); 
            }
        }

        // No pair found
        return false;
    }
}