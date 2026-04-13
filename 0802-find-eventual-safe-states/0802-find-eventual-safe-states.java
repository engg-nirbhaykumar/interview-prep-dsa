class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;

        // Step 1: Create reversed graph
        // revAdj[v] will contain all nodes that point to v
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }

        // Step 2: Instead of indegree, this actually stores OUTDEGREE of original graph
        // (number of outgoing edges from each node)
        int[] indegree = new int[V];

        // Build reversed graph + calculate outdegree
        for (int i = 0; i < V; i++) {
            for (int neighbour : graph[i]) {
                // Reverse edge: neighbour → i
                revAdj.get(neighbour).add(i);

                // Count outgoing edge from i
                indegree[i]++;
            }
        }

        // Step 3: Queue for BFS (Kahn's Algorithm)
        Queue<Integer> q = new LinkedList<>();

        // safe[i] = true means node i is eventually safe
        boolean[] safe = new boolean[V];

        // Step 4: Add all terminal nodes (outdegree = 0)
        // These nodes are always safe
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                safe[i] = true; // terminal nodes are safe
            }
        }

        // Step 5: Process queue (BFS)
        while (!q.isEmpty()) {
            int node = q.poll();

            // Traverse all nodes that point to current node
            // (i.e., parents in original graph)
            for (int neighbour : revAdj.get(node)) {

                // Remove the edge neighbour → node
                indegree[neighbour]--;

                // If neighbour now has no outgoing edges left,
                // it means all its paths lead to safe nodes
                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                    safe[neighbour] = true;
                }
            }
        }

        // Step 6: Collect all safe nodes
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }

        return result;
    }
}