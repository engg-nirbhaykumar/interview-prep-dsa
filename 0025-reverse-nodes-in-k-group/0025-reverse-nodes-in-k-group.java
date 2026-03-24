class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Edge case: empty list or single node → no reversal needed
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;

        // Step 1: Check if there are at least k nodes available
        // If not, return head as it is (no reversal for last group)
        for (int i = 0; i < k; i++) {
            if (curr == null)
                return head;
            curr = curr.next;
        }

        // Step 2: Reverse first k nodes
        curr = head;
        ListNode prev = null;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next; // store next node
            curr.next = prev; // reverse current node's pointer
            prev = curr; // move prev forward
            curr = next; // move curr forward
        }

        // Step 3: Recursively reverse remaining list
        // 'head' is now the last node of reversed group
        // so connect it to result of next recursion
        head.next = reverseKGroup(curr, k);

        // Step 4: Return new head of this reversed group
        return prev;
    }
}