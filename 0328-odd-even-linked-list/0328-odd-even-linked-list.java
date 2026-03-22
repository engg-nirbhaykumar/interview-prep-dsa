class Solution {
    public ListNode oddEvenList(ListNode head) {

        // Edge case: if list is empty or has only one node
        if (head == null || head.next == null)
            return head;

        // 'odd' pointer starts at 1st node
        ListNode odd = head;

        // 'even' pointer starts at 2nd node
        ListNode even = head.next;

        // Store head of even list to connect later
        ListNode evenHead = even;

        // Traverse while there are at least two nodes ahead
        while (even != null && even.next != null) {

            // Step 1: Link current odd node to next odd node
            // (skip the even node)
            odd.next = even.next;
            odd = odd.next; // move odd pointer forward

            // Step 2: Link current even node to next even node
            // (skip the odd node we just connected)
            even.next = odd.next;
            even = even.next; // move even pointer forward
        }

        // Step 3: Attach even list after odd list
        odd.next = evenHead;

        // Return modified list
        return head;
    }
}