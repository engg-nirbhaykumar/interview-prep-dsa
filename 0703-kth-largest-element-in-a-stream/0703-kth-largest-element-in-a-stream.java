class KthLargest {

    // Min-heap to store the k largest elements seen so far
    // The smallest among these k elements (root) will be the kth largest overall
    PriorityQueue<Integer> minHeap;

    // We need to remember k
    private int k;

    // Constructor: initialize heap and process initial numbers
    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>(); // Default PQ in Java is a min-heap
        this.k = k;

        // Add all existing numbers using the same logic as stream additions
        // This ensures heap always maintains only k largest elements
        for (int num : nums) {
            add(num);
        }
    }

    // Adds a new value to the stream and returns the kth largest element
    public int add(int val) {

        // Step 1: Add new value into heap
        minHeap.offer(val);

        // Step 2: If heap size exceeds k, remove the smallest element
        // This ensures we only keep the k largest elements seen so far
        if (minHeap.size() > k) {
            minHeap.poll(); // removes the smallest element
        }

        // Step 3: The root of the min-heap is the kth largest element
        // Because heap contains exactly k largest elements,
        // and the smallest among them = kth largest overall
        return minHeap.peek();
    }
}
