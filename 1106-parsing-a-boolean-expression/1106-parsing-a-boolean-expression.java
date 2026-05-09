class Solution {

    // Function to evaluate expression inside brackets
    // based on operator and collected boolean values
    private char solveOp(char op, List<Character> values) {

        // NOT operator
        // !(t) = f
        // !(f) = t
        if (op == '!')
            return values.get(0) == 't' ? 'f' : 't';

        // AND operator
        // If any value is false -> false
        // Else true
        if (op == '&')
            return values.stream().anyMatch(ch -> ch == 'f') ? 'f' : 't';

        // OR operator
        // If any value is true -> true
        // Else false
        if (op == '|')
            return values.stream().anyMatch(ch -> ch == 't') ? 't' : 'f';

        // Default return
        return 't';
    }

    public boolean parseBoolExpr(String expression) {

        // Stack to process expression
        Stack<Character> stack = new Stack<>();

        // Traverse each character of expression
        for (char ch : expression.toCharArray()) {

            // Ignore commas
            if (ch == ',')
                continue;

            // When closing bracket found,
            // evaluate current sub-expression
            if (ch == ')') {

                // Store values inside current brackets
                List<Character> values = new ArrayList<>();

                // Pop until opening bracket '('
                while (stack.peek() != '(') {
                    values.add(stack.pop());
                }

                // Remove '('
                stack.pop();

                // Operator before '(' => !, &, |
                char op = stack.pop();

                // Evaluate and push result back
                stack.push(solveOp(op, values));

            } else {

                // Push operators, brackets, t, f
                stack.push(ch);
            }
        }

        // Final result remains in stack
        return stack.peek() == 't';
    }
}