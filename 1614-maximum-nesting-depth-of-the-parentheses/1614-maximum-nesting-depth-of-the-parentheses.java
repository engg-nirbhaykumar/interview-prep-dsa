class Solution {
    public int maxDepth(String s) {

        // Stack to track the current nesting of parentheses
        Stack<Character> st = new Stack<>();

        // Variable to store the maximum depth encountered
        int result = 0;

        // Traverse each character in the string
        for (char ch : s.toCharArray()) {

            // If it's an opening bracket, push to stack (depth increases)
            if (ch == '(') {
                st.push(ch);
            }
            // If it's a closing bracket, pop from stack (depth decreases)
            else if (ch == ')') {
                st.pop();
            }

            // After each operation, update the maximum depth so far
            result = Math.max(result, st.size());
        }

        // Return the maximum nesting depth
        return result;
    }
}
