class Solution {

    // Helper class to store node with its vertical (column) and level (row)
    static class Tuple {
        private TreeNode node;
        private int vertical; // column index (left → negative, right → positive)
        private int level; // row index (depth)

        public Tuple(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // Structure:
        // vertical → (level → minHeap of node values)
        // TreeMap ensures sorting of vertical (left → right)
        // Inner TreeMap ensures sorting of level (top → bottom)
        // PriorityQueue ensures sorting of values (tie-breaking)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Queue for BFS traversal
        Queue<Tuple> q = new LinkedList<>();

        // Start with root at vertical = 0, level = 0
        q.offer(new Tuple(root, 0, 0));

        // Standard BFS traversal
        while (!q.isEmpty()) {

            Tuple t = q.poll();
            TreeNode curr = t.node;
            int vertical = t.vertical;
            int level = t.level;

            // Initialize structures if not already present
            map.putIfAbsent(vertical, new TreeMap<>());
            map.get(vertical).putIfAbsent(level, new PriorityQueue<>());

            // Add current node value to minHeap
            // (handles sorting if multiple nodes share same vertical & level)
            map.get(vertical).get(level).offer(curr.val);

            // Move to left child:
            // vertical decreases, level increases
            if (curr.left != null) {
                q.offer(new Tuple(curr.left, vertical - 1, level + 1));
            }

            // Move to right child:
            // vertical increases, level increases
            if (curr.right != null) {
                q.offer(new Tuple(curr.right, vertical + 1, level + 1));
            }
        }

        // Prepare final result
        List<List<Integer>> result = new ArrayList<>();

        // Traverse verticals in sorted order
        for (TreeMap<Integer, PriorityQueue<Integer>> verticals : map.values()) {

            List<Integer> response = new ArrayList<>();

            // Traverse levels (top → bottom)
            for (PriorityQueue<Integer> levels : verticals.values()) {

                // Extract elements in sorted order (minHeap)
                while (!levels.isEmpty()) {
                    response.add(levels.poll());
                }
            }

            result.add(response);
        }

        return result;
    }
}