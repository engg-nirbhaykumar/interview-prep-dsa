class Solution {

    // DFS function to traverse all connected nodes
    private void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        // Mark current node as visited
        visited[node] = true;

        // Traverse all its neighbours
        for (int neighbour : adj.get(node)) {
            // If neighbour is not visited, visit it
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adj);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize list for each node
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Convert adjacency matrix → adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // If i and j are connected (and not same node)
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j); // add edge i → j
                }
            }
        }

        // Step 3: Visited array to track visited cities
        boolean[] visited = new boolean[n];

        int provinces = 0; // count of connected components

        // Step 4: Traverse all nodes
        for (int i = 0; i < n; i++) {

            // If node is not visited, it's a new province
            if (!visited[i]) {
                dfs(i, visited, adj); // visit all connected nodes
                provinces++; // increment province count
            }
        }

        // Final answer
        return provinces;
    }
}