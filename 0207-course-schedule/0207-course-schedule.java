class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Step 1: Build adjacency list
        // graph[u] contains all courses dependent on u
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Step 2: Create in-degree array
        // inDegree[i] = number of prerequisites for course i
        int[] inDegree = new int[numCourses];

        // Fill adjacency list and in-degree
        for (int[] preq : prerequisites) {
            int u = preq[1]; // prerequisite course
            int v = preq[0]; // dependent course

            // edge: u -> v
            adjList.get(u).add(v);

            // increase in-degree of v
            inDegree[v]++;
        }

        // Step 3: Initialize queue with nodes having in-degree 0
        // These are courses with no prerequisites
        Queue<Integer> q = new LinkedList<>();

        // Count of courses we are able to complete
        int completed = 0;

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                completed++; // can take this course immediately
            }
        }

        // Step 4: BFS (Topological Sort)
        while (!q.isEmpty()) {

            int node = q.poll();

            // Traverse all courses dependent on current course
            for (int neighbour : adjList.get(node)) {

                // Remove dependency
                inDegree[neighbour]--;

                // If no more prerequisites left
                if (inDegree[neighbour] == 0) {
                    q.offer(neighbour);
                    completed++; // course can now be completed
                }
            }
        }

        // Step 5: If all courses are completed → no cycle
        // If some courses are left → cycle exists
        return completed == numCourses;
    }
}