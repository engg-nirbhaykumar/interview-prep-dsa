class Solution {
    public int maxDepth(String s) {

        // Tracks the current number of open parentheses
        int openingBracket = 0;

        // Stores the maximum depth encountered
        int result = 0;

        // Iterate through every character in the string
        for (char ch : s.toCharArray()) {

            // If we see an opening bracket, increase depth
            if (ch == '(') {
                openingBracket++;
            }
            // If we see a closing bracket, decrease depth
            else if (ch == ')') {
                openingBracket--;
            }

            // Update the maximum depth reached so far
            result = Math.max(result, openingBracket);
        }

        // Final maximum nesting depth
        return result;
    }
}
