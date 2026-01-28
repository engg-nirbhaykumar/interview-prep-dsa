class Solution {

    // Directions → down, right, left, up
    private final int[][] dir = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    int n; // rows
    int m; // columns

    // DFS to check if word can be formed starting from (i, j)
    private boolean dfs(char[][] board, String word, int i, int j, int index) {

        // Base case: if all characters are matched
        if (index == word.length())
            return true;

        // Boundary check + character mismatch
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(index))
            return false;

        // Mark current cell as visited (to avoid reuse)
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 directions
        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            // If any path returns true → word exists
            if (dfs(board, word, ni, nj, index + 1))
                return true;
        }

        // Backtrack: restore original value
        board[i][j] = temp;

        return false;
    }

    public boolean exist(char[][] board, String word) {

        n = board.length;
        m = board[0].length;

        // Try starting DFS from every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // If word found starting here → return true
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        // Word not found anywhere
        return false;
    }
}
