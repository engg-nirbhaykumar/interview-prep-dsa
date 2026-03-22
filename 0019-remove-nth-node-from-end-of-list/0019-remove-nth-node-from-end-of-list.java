class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 0: Create dummy node to handle edge cases (like deleting head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Step 1: Move 'fast' pointer (n + 1) steps ahead
        // This creates a gap of n nodes between slow and fast
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 2: Move both pointers until fast reaches end
        // 'slow' will stop at node BEFORE the one to delete
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Delete the nth node from end
        slow.next = slow.next.next;

        // Step 4: Return updated list (skip dummy)
        return dummy.next;
    }
}