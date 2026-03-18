public class Solution {

    public ListNode detectCycle(ListNode head) {

        // Initialize two pointers:
        // slow -> moves 1 step
        // fast -> moves 2 steps
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {

            slow = slow.next; // move slow by 1
            fast = fast.next.next; // move fast by 2

            // If they meet → cycle detected
            if (slow == fast) {

                // Step 2: Find the start of the cycle

                // Initialize a new pointer from head
                ListNode start = head;

                // Move both pointers one step at a time:
                // - 'start' from head
                // - 'slow' from meeting point
                // They will meet at the cycle start
                while (slow != start) {
                    start = start.next;
                    slow = slow.next;
                }

                // Return the node where cycle begins
                return start;
            }
        }

        // If fast reaches null → no cycle
        return null;
    }
}