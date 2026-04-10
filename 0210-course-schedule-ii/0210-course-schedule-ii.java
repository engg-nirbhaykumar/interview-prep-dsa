class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Build adjacency list
        // graph[u] contains all courses that depend on u
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
            int v = preq[0]; // course dependent on u

            // Directed edge u -> v
            adjList.get(u).add(v);

            // Increase in-degree of v
            inDegree[v]++;
        }

        // Step 3: Initialize queue with courses having no prerequisites
        Queue<Integer> q = new LinkedList<>();

        // Array to store topological order (course completion order)
        int[] completed = new int[numCourses];

        // Pointer to insert into result array
        int index = 0;

        // Add all nodes with in-degree 0 to queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);

                // These courses can be taken immediately
                completed[index++] = i;
            }
        }

        // Step 4: Perform BFS (Kahn’s Algorithm)
        while (!q.isEmpty()) {

            int node = q.poll();

            // Traverse all dependent courses
            for (int neighbour : adjList.get(node)) {

                // Remove dependency
                inDegree[neighbour]--;

                // If no prerequisites left, add to queue
                if (inDegree[neighbour] == 0) {
                    q.offer(neighbour);

                    // Add to result (valid course order)
                    completed[index++] = neighbour;
                }
            }
        }

        // Step 5: Check if all courses are processed
        // If yes → return valid order
        // If not → cycle exists → return empty array
        return index == numCourses ? completed : new int[0];
    }
}