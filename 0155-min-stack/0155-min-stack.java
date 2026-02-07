class MinStack {

    // Pair class stores:
    // val → actual stack value
    // minVal → minimum value in stack at this level
    class Pair {
        int val;
        int minVal;

        public Pair(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }

    // Stack of Pairs instead of integers
    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        // If stack is empty, the pushed value is the minimum itself
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val));
        } else {
            // Compare new value with current minimum
            int newMin = Math.min(val, stack.peek().minVal);

            // Store both value and updated minimum
            stack.push(new Pair(val, newMin));
        }
    }

    public void pop() {
        // Remove top element if stack is not empty
        if (stack.isEmpty())
            return;
        stack.pop();
    }

    public int top() {
        // Return top element value
        if (stack.isEmpty())
            return -1;
        return stack.peek().val;
    }

    public int getMin() {
        // Minimum is stored at top Pair
        if (stack.isEmpty())
            return -1;
        return stack.peek().minVal;
    }
}
