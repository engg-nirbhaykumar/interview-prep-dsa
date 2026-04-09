class Solution {

    // DFS function to try coloring the graph
    private boolean dfs(int[][] graph, int node, int[] color, int currColor) {

        // Assign current color to this node
        color[node] = currColor;

        // Traverse all neighbors
        for (int neighbour : graph[node]) {

            // Case 1: If neighbor already has same color → conflict
            if (color[neighbour] == currColor)
                return false;

            // Case 2: If neighbor is not colored yet
            else if (color[neighbour] == -1) {

                // Try coloring neighbor with opposite color
                // If conflict occurs deeper → return false
                if (dfs(graph, neighbour, color, 1 - currColor) == false)
                    return false;
            }
        }

        // No conflicts found for this path
        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        // color[i] = -1 → not visited
        // color[i] = 0 or 1 → two different groups
        int[] color = new int[n];
        Arrays.fill(color, -1);

        // Traverse all nodes (important for disconnected graph)
        for (int i = 0; i < n; i++) {

            // If node is not yet colored, start DFS
            if (color[i] == -1) {

                // Start with color 0
                if (dfs(graph, i, color, 0) == false) {
                    return false; // conflict found
                }
            }
        }

        // Graph can be colored with 2 colors → Bipartite
        return true;
    }
}