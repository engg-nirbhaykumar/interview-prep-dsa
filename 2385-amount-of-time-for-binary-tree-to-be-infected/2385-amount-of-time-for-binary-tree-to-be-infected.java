class Solution {

    // Map to store child -> parent relationship
    private Map<TreeNode, TreeNode> parent = new HashMap<>();

    // Set to track visited nodes during BFS (to avoid cycles)
    private Set<TreeNode> visited = new HashSet<>();

    // DFS traversal to build parent mapping
    private void addParent(TreeNode root) {
        if (root == null)
            return;

        // If left child exists, map it to its parent
        if (root.left != null) {
            parent.put(root.left, root);
        }
        // Recurse on left subtree
        addParent(root.left);

        // If right child exists, map it to its parent
        if (root.right != null) {
            parent.put(root.right, root);
        }
        // Recurse on right subtree
        addParent(root.right);
    }

    // DFS to locate the node where infection starts
    private TreeNode findStart(TreeNode root, int start) {
        if (root == null)
            return null;

        // Found the start node
        if (root.val == start)
            return root;

        // Search in left subtree
        TreeNode left = findStart(root.left, start);
        if (left != null)
            return left;

        // Search in right subtree
        TreeNode right = findStart(root.right, start);
        if (right != null)
            return right;

        return null;
    }

    public int amountOfTime(TreeNode root, int start) {
        if (root == null)
            return 0;

        // Step 1: Build parent map (to allow upward traversal)
        addParent(root);

        // Step 2: Find the starting node
        TreeNode startNode = findStart(root, start);

        // Step 3: BFS from start node
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(startNode);

        // Mark start node as visited
        visited.add(startNode);

        int time = 0;

        // BFS traversal (level by level = time units)
        while (!q.isEmpty()) {

            int levelSize = q.size();

            // Each level represents 1 unit of time
            time++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();

                // Traverse left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }

                // Traverse right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }

                // Traverse parent
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    q.offer(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }
        }

        // We started time from 0 but incremented before processing first level
        // So subtract 1 to get correct time
        return time - 1;
    }
}