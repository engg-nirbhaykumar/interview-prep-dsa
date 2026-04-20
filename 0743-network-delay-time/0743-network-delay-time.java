class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Build graph (Adjacency List)
        // graph[u] -> list of {v, weight}
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Fill graph using given edges
        for (int[] time : times) {
            int u = time[0];   // source node
            int v = time[1];   // destination node
            int wt = time[2];  // travel time

            graph.get(u).add(new int[] { v, wt });
        }

        // Step 2: Distance array
        // dist[i] = minimum time to reach node i from source k
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance to source is 0
        dist[k] = 0;

        // Step 3: Min Heap (Priority Queue)
        // Stores {node, currentDistance}
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1]));

        // Start from source node
        q.offer(new int[] { k, 0 });

        // Step 4: Dijkstra's Algorithm
        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int u = curr[0];  // current node
            int d = curr[1];  // current shortest distance

            // IMPORTANT:
            // If this entry is outdated (we already found a better path), skip it
            if (d > dist[u])
                continue;

            // Explore all neighbors of current node
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];   // adjacent node
                int wt = neighbor[1]; // edge weight

                // Relaxation step:
                // If going via 'u' gives a shorter path to 'v'
                if (d + wt < dist[v]) {
                    dist[v] = d + wt;

                    // Push updated distance into PQ
                    q.offer(new int[] { v, dist[v] });
                }
            }
        }

        // Step 5: Find the maximum time among all nodes
        // Because signal must reach ALL nodes
        int minTime = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {

            // If any node is unreachable → return -1
            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            // Track maximum delay
            minTime = Math.max(minTime, dist[i]);
        }

        // Final answer = time taken for farthest node
        return minTime;
    }
}