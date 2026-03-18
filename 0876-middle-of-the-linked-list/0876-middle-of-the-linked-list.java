class Solution {
    public ListNode middleNode(ListNode head) {

        // Initialize two pointers:
        // slow -> moves 1 step at a time
        // fast -> moves 2 steps at a time
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        // fast reaches end faster than slow
        while (fast != null && fast.next != null) {

            // Move slow by 1 step
            slow = slow.next;

            // Move fast by 2 steps
            fast = fast.next.next;
        }

        // When fast reaches the end:
        // slow will be at the middle
        // (for even length, it points to the second middle node)
        return slow;
    }
}