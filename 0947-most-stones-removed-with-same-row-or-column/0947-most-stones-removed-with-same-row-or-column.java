class Solution {
    int[] parent;
    int[] rank;

    // Find the ultimate parent (root) of node x
    // Uses path compression to flatten the structure for faster future queries
    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]); // Path compression
    }

    // Union two nodes using union by rank
    // Attach smaller tree under larger tree to keep DSU balanced
    public void union(int x, int y) {
        int xPar = find(x);
        int yPar = find(y);

        // If both nodes already belong to same component → do nothing
        if (xPar == yPar)
            return;

        if (rank[xPar] > rank[yPar]) {
            parent[yPar] = xPar;
        } else if (rank[xPar] < rank[yPar]) {
            parent[xPar] = yPar;
        } else {
            parent[yPar] = xPar;
            rank[xPar]++; // Increase rank when both trees have same height
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        parent = new int[n];
        rank = new int[n];

        // Initialize DSU
        // Each stone is initially its own parent (n separate components)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int components = n; // Initially, each stone is a separate component

        // Compare every pair of stones
        // If two stones share same row OR same column → they are connected
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // Same row OR same column → can be grouped
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {

                    // If they are not already in same component → union them
                    if (find(i) != find(j)) {
                        union(i, j);
                        components--; // Reduce number of components
                    }
                }
            }
        }

        // Key Idea:
        // In each connected component, we can remove all stones except one
        // So, max stones removed = total stones - number of components
        return n - components;
    }
}