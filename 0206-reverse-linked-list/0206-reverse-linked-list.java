class Solution {
    public ListNode reverseList(ListNode head) {

        // 'curr' will traverse the list
        ListNode curr = head;

        // 'prev' will store the previous node (initially null)
        ListNode prev = null;

        // Traverse the entire linked list
        while (curr != null) {

            // Store next node before breaking the link
            ListNode next = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move 'prev' one step forward
            prev = curr;

            // Move 'curr' one step forward
            curr = next;
        }

        // At the end, 'prev' will be the new head of reversed list
        return prev;
    }
}