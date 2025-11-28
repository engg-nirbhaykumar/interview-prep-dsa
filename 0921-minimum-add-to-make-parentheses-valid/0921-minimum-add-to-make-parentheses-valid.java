class Solution {

    public int minAddToMakeValid(String s) {

        // Stack used to track unmatched parentheses
        Stack<Character> stack = new Stack<>();

        // Traverse through each character of the string
        for (char ch : s.toCharArray()) {

            // If it's an opening bracket, push into stack
            if (ch == '(') {
                stack.push(ch);
            } else {

                // If it's a closing bracket and top of stack is an opening bracket,
                // they form a valid pair, so pop the opening bracket
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                // Otherwise, this closing bracket is unmatched,
                // push it into the stack
                else {
                    stack.push(ch);
                }
            }
        }

        // Stack contains all unmatched parentheses.
        // Number of insertions needed = stack size.
        return stack.size();
    }
}
