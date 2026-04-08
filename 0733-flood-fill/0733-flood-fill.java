class Solution {

    // 4 possible directions: down, right, up, left
    private final int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    // Check if next cell is valid:
    // 1. Inside grid bounds
    // 2. Has the original color (so it should be filled)
    private boolean isValid(int ni, int nj, int n, int m, int color, int[][] image) {
        return (ni >= 0 && ni < n && nj >= 0 && nj < m && image[ni][nj] == color);
    }

    // DFS to fill connected component
    private void dfs(int[][] image, int ci, int cj, int n, int m, int newColor, int color) {

        // Step 1: Color current cell
        image[ci][cj] = newColor;

        // Step 2: Explore all 4 directions
        for (int[] d : dirs) {
            int ni = ci + d[0]; // next row
            int nj = cj + d[1]; // next column

            // Step 3: If valid (same original color), continue DFS
            if (isValid(ni, nj, n, m, color, image)) {
                dfs(image, ni, nj, n, m, newColor, color);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // Original color at starting pixel
        int color = image[sr][sc];

        // Edge case: if new color is same as original, no need to process
        // (prevents infinite recursion)
        if (color == newColor)
            return image;

        int n = image.length;
        int m = image[0].length;

        // Start DFS from source pixel
        dfs(image, sr, sc, n, m, newColor, color);

        return image;
    }
}