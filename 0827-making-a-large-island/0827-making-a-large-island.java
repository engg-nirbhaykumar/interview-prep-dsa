class Solution {

    int[] parent;
    int[] size;

    // Find with path compression
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union by size
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        // attach smaller tree to bigger tree
        if (size[px] > size[py]) {
            parent[py] = px;
            size[px] += size[py];
        } else {
            parent[px] = py;
            size[py] += size[px];
        }
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        parent = new int[n * n];
        size = new int[n * n];

        // initialize DSU
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[][] dir = { {0,1},{1,0},{0,-1},{-1,0} };

        // Step 1: connect all 1's
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 0) continue;

                int node = r * n + c;

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && grid[nr][nc] == 1) {

                        int adjNode = nr * n + nc;
                        union(node, adjNode);
                    }
                }
            }
        }

        int max = 0;

        // Step 2: try flipping each 0
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 1) continue;

                HashSet<Integer> set = new HashSet<>();

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && grid[nr][nc] == 1) {

                        int parentNode = find(nr * n + nc);
                        set.add(parentNode); // avoid duplicates
                    }
                }

                int totalSize = 1; // flipped cell

                for (int p : set) {
                    totalSize += size[p];
                }

                max = Math.max(max, totalSize);
            }
        }

        // Step 3: edge case (all 1s)
        for (int i = 0; i < n * n; i++) {
            if (parent[i] == i) {
                max = Math.max(max, size[i]);
            }
        }

        return max;
    }
}