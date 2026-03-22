class Solution {
    public ListNode deleteMiddle(ListNode head) {

        // Edge case: if list is empty or has only one node
        // Deleting the middle results in an empty list
        if (head == null || head.next == null) {
            return null; // IMPORTANT: should return null, not head
        }

        // 'slow' will reach the middle node
        // 'fast' moves twice as fast
        ListNode prev = null; // to keep track of node before 'slow'
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            prev = slow; // store previous node of slow
            slow = slow.next; // move slow by 1
            fast = fast.next.next; // move fast by 2
        }

        // Now 'slow' is at the middle node
        // 'prev' is the node before middle

        // Delete the middle node
        prev.next = slow.next;

        // Return modified list
        return head;
    }
}