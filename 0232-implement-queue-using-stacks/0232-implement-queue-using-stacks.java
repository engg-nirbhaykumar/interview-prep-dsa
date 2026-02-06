class MyQueue {
    // s1 will always keep the FRONT of the queue on top
    Stack<Integer> s1;
    Stack<Integer> s2; // Helper stack

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        // Step 1: Move all elements from s1 to s2
        // This empties s1 so new element can go at bottom later
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Step 2: Push new element into s1
        // This element should be the LAST in queue (rear)
        s1.push(x);

        // Step 3: Move everything back from s2 to s1
        // Now older elements are placed above the new element
        // So the oldest element remains on TOP of s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        // Top of s1 represents the FRONT of the queue
        return s1.pop();
    }

    public int peek() {
        // Peek the front element
        return s1.peek();
    }

    public boolean empty() {
        // Queue is empty when s1 has no elements
        return s1.isEmpty();
    }
}
