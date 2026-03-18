class Solution {

    // Recursive helper function
    // 'curr' -> current node being processed
    // 'prev' -> previous node (used to reverse the link)
    private ListNode reverseListRec(ListNode curr, ListNode prev) {

        // Base case:
        // If we reach end of list, 'prev' will be the new head
        if (curr == null)
            return prev;

        // Store next node before breaking the link
        ListNode next = curr.next;

        // Reverse the current node's pointer
        curr.next = prev;

        // Move forward in the list:
        // next becomes new curr
        // curr becomes new prev
        return reverseListRec(next, curr);
    }

    public ListNode reverseList(ListNode head) {

        // Start recursion with:
        // curr = head, prev = null
        return reverseListRec(head, null);
    }
}