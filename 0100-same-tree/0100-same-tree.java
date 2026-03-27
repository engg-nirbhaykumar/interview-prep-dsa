class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Queues to traverse both trees level by level
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        // Start with root nodes of both trees
        q1.offer(p);
        q2.offer(q);

        // Traverse both queues simultaneously
        while (!q1.isEmpty() && !q2.isEmpty()) {

            // Get current nodes from both trees
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            // Case 1: both nodes are null → continue checking
            if (n1 == null && n2 == null)
                continue;

            // Case 2: one is null, other is not → trees differ
            if (n1 == null || n2 == null)
                return false;

            // Case 3: values are different → trees differ
            if (n1.val != n2.val)
                return false;

            // Add left children of both nodes to respective queues
            q1.offer(n1.left);
            q2.offer(n2.left);

            // Add right children of both nodes to respective queues
            q1.offer(n1.right);
            q2.offer(n2.right);
        }

        // Both queues should be empty at the same time for trees to be identical
        return q1.isEmpty() && q2.isEmpty();
    }
}