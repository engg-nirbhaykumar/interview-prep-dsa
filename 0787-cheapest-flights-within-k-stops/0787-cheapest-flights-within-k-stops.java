class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Step 1: Build adjacency list (graph)
        // graph[u] -> list of {v, cost}
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Fill graph using flights input
        for (int[] flight : flights) {
            int u = flight[0];   // source city
            int v = flight[1];   // destination city
            int cost = flight[2]; // price

            graph.get(u).add(new int[] { v, cost });
        }

        // Step 2: Distance array
        // dist[i] = minimum cost to reach node i
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Step 3: Queue for BFS
        // Each element: {currentNode, currentCost}
        Queue<int[]> q = new LinkedList<>();

        // Start from source
        q.offer(new int[] { src, 0 });
        dist[src] = 0;

        // Step 4: BFS traversal with level control
        // level = number of edges used (stops)
        int level = 0;

        while (!q.isEmpty() && level <= k) {

            int size = q.size();

            // Process all nodes at current level (same number of stops)
            while (size-- > 0) {
                int[] curr = q.poll();

                int u = curr[0]; // current node
                int d = curr[1]; // cost to reach u

                // Explore neighbors
                for (int[] neighbour : graph.get(u)) {
                    int v = neighbour[0];     // next node
                    int cost = neighbour[1];  // edge cost

                    // Relaxation step:
                    // If we found cheaper cost to reach v
                    if (d + cost < dist[v]) {
                        dist[v] = d + cost;

                        // Push into queue for next level
                        q.offer(new int[] { v, dist[v] });
                    }
                }
            }

            // Move to next level (one more stop)
            level++;
        }

        // Step 5: Return result
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}