class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {

        // Step 1: Build graph (Adjacency List)
        // graph[u] -> list of {v, weight}
        List<List<long[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Since roads are bidirectional (undirected graph)
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            graph.get(u).add(new long[] { v, wt });
            graph.get(v).add(new long[] { u, wt });
        }

        // Step 2: Distance array
        // dist[i] = shortest distance to reach node i
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        // Step 3: Ways array
        // ways[i] = number of shortest paths to reach node i
        int[] ways = new int[n];

        // Step 4: Min Heap (node, distance)
        PriorityQueue<long[]> q = new PriorityQueue<>(
                (a, b) -> Long.compare(a[1], b[1]));

        // Start from node 0 (source)
        q.offer(new long[] { 0, 0 });
        dist[0] = 0;

        // Only one way to reach source
        ways[0] = 1;

        // Step 5: Dijkstra + Path Counting
        while (!q.isEmpty()) {

            long[] curr = q.poll();
            int u = (int) curr[0]; // current node
            long d = curr[1];     // current distance

            // IMPORTANT OPTIMIZATION:
            // Skip outdated entries (classic Dijkstra optimization)
            if (d > dist[u]) continue;

            // Explore neighbors
            for (long[] neighbor : graph.get(u)) {
                int v = (int) neighbor[0];
                long wt = neighbor[1];

                // Case 1: Found shorter path to v
                if (d + wt < dist[v]) {
                    dist[v] = d + wt;

                    // Push updated distance into PQ
                    q.offer(new long[] { v, dist[v] });

                    // Inherit number of ways from u
                    ways[v] = ways[u];
                }

                // Case 2: Found another shortest path
                else if (d + wt == dist[v]) {

                    // Add number of ways
                    ways[v] = (ways[u] + ways[v]) % MOD;
                }
            }
        }

        // Destination is node (n-1)
        return ways[n - 1];
    }
}