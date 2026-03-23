class Solution {
    public Node flatten(Node head) {

        // Edge case: empty list
        if (head == null) {
            return null;
        }

        Node curr = head;

        // Traverse the list
        while (curr != null) {

            // If current node has a child list
            if (curr.child != null) {

                // Store next node (to reconnect later)
                Node next = curr.next;

                // Step 1: Flatten the child list recursively
                curr.next = flatten(curr.child);

                // Connect flattened child list back to current node
                curr.next.prev = curr;

                // Step 2: Remove child pointer
                curr.child = null;

                // Step 3: Move to the end of the flattened child list
                while (curr.next != null) {
                    curr = curr.next;
                }

                // Step 4: Reconnect the saved next node
                if (next != null) {
                    curr.next = next;
                    next.prev = curr;
                }
            }

            // Move to next node
            curr = curr.next;
        }

        // Return head of flattened list
        return head;
    }
}