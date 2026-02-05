class MyStack {
    // We use a single queue to simulate stack behavior
    Queue<Integer> q;

    public MyStack() {
        // LinkedList implements Queue interface
        q = new LinkedList<>();
    }

    public void push(int x) {
        // Step 1: Add new element to the queue
        q.offer(x);

        // Step 2: Rotate all previous elements behind the new element
        // This makes the newly added element come to the front,
        // which mimics stack's LIFO behavior
        for (int i = 0; i < q.size() - 1; i++) {
            q.offer(q.poll());  // remove from front and add to rear
        }
    }

    public int pop() {
        // The front of the queue represents the top of the stack
        // So removing from queue front = stack pop
        return q.poll();
    }

    public int top() {
        // Peek front of queue = top of stack
        return q.peek();
    }

    public boolean empty() {
        // Stack is empty if queue is empty
        return q.isEmpty();
    }
}
