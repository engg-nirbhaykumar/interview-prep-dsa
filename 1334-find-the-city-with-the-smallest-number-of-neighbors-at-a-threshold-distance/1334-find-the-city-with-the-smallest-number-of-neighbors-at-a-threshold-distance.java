class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        // Step 1: Create distance matrix
        int[][] dist = new int[n][n];

        // Initialize with infinity
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e8);
            dist[i][i] = 0; // distance to itself = 0
        }

        // Fill given edges (undirected)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Step 2: Floyd-Warshall
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][via] != (int) 1e8 && dist[via][j] != (int) 1e8) {
                        dist[i][j] = Math.min(
                                dist[i][j],
                                dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

        // Step 3: Find answer
        int city = -1;
        int minReachable = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // Pick city with minimum reachable nodes
            // If tie → choose larger index
            if (count <= minReachable) {
                minReachable = count;
                city = i;
            }
        }

        return city;
    }
}