class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Edge case: no lists provided
        if (lists == null || lists.length == 0)
            return null;

        // Min Heap to always extract the smallest node among k lists
        // Comparator ensures nodes are ordered by their value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val));

        // Step 1: Add the head of each list to the heap
        // Only non-null heads are added
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Dummy node helps simplify list construction
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;  // Pointer to build the result list

        // Step 2: Process nodes in increasing order
        while (!minHeap.isEmpty()) {

            // Extract the smallest node among current heads
            ListNode minNode = minHeap.poll();

            // Create a NEW node to avoid modifying original lists
            tail.next = new ListNode(minNode.val);
            tail = tail.next;

            // If extracted node has a next element, push it into heap
            // This keeps heap size at most k
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        // Result list starts after dummy node
        return dummy.next;
    }
}
