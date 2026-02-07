class Solution {
    public boolean isValid(String s) {
        // Stack to store opening brackets
        Stack<Character> st = new Stack<>();

        // Traverse each character of string
        for (char ch : s.toCharArray()) {

            // If it's an opening bracket, push onto stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // If it's a closing bracket but stack is empty → invalid
                if (st.isEmpty())
                    return false;

                // Check if the closing bracket matches the last opening bracket
                // If not matched, return false
                else if ((ch == ')' && st.pop() != '(') ||
                        (ch == '}' && st.pop() != '{') ||
                        (ch == ']' && st.pop() != '[')) {
                    return false;
                }
            }
        }

        // At the end, stack must be empty for valid parentheses
        // If stack still has elements → some brackets were not closed
        return st.isEmpty();
    }
}
