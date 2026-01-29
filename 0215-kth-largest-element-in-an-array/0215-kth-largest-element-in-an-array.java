class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Min heap will store the k largest elements seen so far
        // Smallest among them will be at the top
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {

            // Add current number into heap
            minHeap.add(num);

            // If heap size exceeds k,
            // remove the smallest element
            // This ensures heap only keeps k largest numbers
            if (minHeap.size() > k) {
                minHeap.poll(); // removes smallest
            }
        }

        // Now heap contains k largest elements,
        // and the top is the kth largest
        return minHeap.peek();
    }
}
