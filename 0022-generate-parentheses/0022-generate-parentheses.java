class Solution {

    // Stores all valid combinations of parentheses
    List<String> result;

    // Main function to generate parentheses
    public List<String> generateParenthesis(int n) {

        // Initialize result list
        result = new ArrayList<>();

        // Start backtracking with:
        // current string = ""
        // open brackets used = 0
        // close brackets used = 0
        backTrack(n, "", 0, 0);

        return result;
    }

    // Backtracking helper function
    private void backTrack(int n, String current, int open, int close) {

        // Base case:
        // When the current string reaches length 2*n,
        // it means a valid combination is formed
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // If we can still add an opening bracket '('
        // (we cannot exceed n opening brackets)
        if (open < n) {
            backTrack(n, current + "(", open + 1, close);
        }

        // We can add a closing bracket ')' only if
        // it does not exceed the number of opening brackets
        if (close < open) {
            backTrack(n, current + ")", open, close + 1);
        }
    }
}
