class Solution {

    int[] parent;
    int[] rank;

    // Find with path compression
    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    // Union by rank
    public void union(int x, int y) {
        int xPar = find(x);
        int yPar = find(y);

        if (xPar == yPar)
            return;

        if (rank[xPar] > rank[yPar]) {
            parent[yPar] = xPar;
        } else if (rank[xPar] < rank[yPar]) {
            parent[xPar] = yPar;
        } else {
            parent[yPar] = xPar;
            rank[xPar]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {

        // Not enough edges
        if (connections.length < n - 1)
            return -1;

        parent = new int[n];
        rank = new int[n];

        // Initialize DSU
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int components = n;

        // Process edges
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            if (find(u) != find(v)) {
                union(u, v);
                components--;
            }
        }

        // Minimum operations = components - 1
        // Note :: n nodes -> n - 1 edges
        return components - 1;
    }
}