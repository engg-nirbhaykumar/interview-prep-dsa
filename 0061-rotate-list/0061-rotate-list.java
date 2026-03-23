class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases: empty list, single node, or no rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1; // initialize length as 1 (since we start from head)
        ListNode curr = head;

        // Traverse the list to find the length and last node
        while (curr.next != null) {
            length++;
            curr = curr.next;
        }

        // Make the list circular by connecting last node to head
        curr.next = head;

        // Reduce k in case it is greater than length
        int rotateStep = k % length;

        // Find the position of new tail:
        // (length - rotateStep) moves from current (last node)
        int stepsToNewTail = length - rotateStep;

        // Move to the new tail node
        for (int i = 0; i < stepsToNewTail; i++) {
            curr = curr.next;
        }

        // The node next to new tail becomes new head
        ListNode newHead = curr.next;

        // Break the circular link to form the final rotated list
        curr.next = null;

        return newHead;
    }
}