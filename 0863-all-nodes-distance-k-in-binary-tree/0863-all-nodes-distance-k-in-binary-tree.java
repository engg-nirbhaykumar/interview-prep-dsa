class Solution {

    // Map to store parent of each node (to treat tree as undirected graph)
    private Map<TreeNode, TreeNode> parent = new HashMap<>();

    // Set to keep track of visited nodes (avoid cycles)
    private Set<TreeNode> visited = new HashSet<>();

    // List to store final result (nodes at distance K)
    private List<Integer> result = new ArrayList<>();

    // Step 1: Build parent mapping using DFS
    private void addParent(TreeNode root) {
        if (root == null)
            return;

        // Map left child → parent
        if (root.left != null) {
            parent.put(root.left, root);
        }
        addParent(root.left);

        // Map right child → parent
        if (root.right != null) {
            parent.put(root.right, root);
        }
        addParent(root.right);
    }

    // Step 2: Perform BFS from target to find nodes at distance K
    private void collectKDistance(TreeNode target, int k) {

        // Queue for BFS traversal
        Queue<TreeNode> q = new LinkedList<>();

        // Start from target node
        q.offer(target);

        // Mark target as visited
        visited.add(target);

        // BFS traversal
        while (!q.isEmpty()) {

            int levelSize = q.size();

            // If current level is K → stop traversal
            if (k == 0)
                break;

            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();

                // Visit left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }

                // Visit right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }

                // Visit parent node (important to move upwards)
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    q.offer(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }

            // Move to next level → reduce distance
            k--;
        }

        // All nodes remaining in queue are at distance K
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // Edge case: empty tree
        if (root == null)
            return result;

        // Step 1: Build parent relationships
        addParent(root);

        // Step 2: BFS from target node
        collectKDistance(target, k);

        return result;
    }
}