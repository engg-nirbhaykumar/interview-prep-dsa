class Solution {

    // Utility function to reverse a linked list
    private ListNode reverse(ListNode curr) {
        ListNode prev = null;

        // Standard iterative reversal
        while (curr != null) {
            ListNode next = curr.next; // store next node
            curr.next = prev; // reverse current node's pointer
            prev = curr; // move prev forward
            curr = next; // move curr forward
        }

        // 'prev' will be the new head of reversed list
        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        // Edge case: empty list or single node is always palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle of the linked list using slow & fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // When fast reaches end, slow will be at middle
        while (fast != null && fast.next != null) {
            slow = slow.next; // move by 1
            fast = fast.next.next; // move by 2
        }

        // Step 2: Reverse the second half starting from 'slow'
        ListNode reversedNode = reverse(slow);

        // Step 3: Compare first half and reversed second half
        ListNode lCrawler = head; // start from beginning
        ListNode rCrawler = reversedNode; // start from reversed second half

        while (rCrawler != null) {
            // If any mismatch → not a palindrome
            if (lCrawler.val != rCrawler.val) {
                return false;
            }

            // Move both pointers
            lCrawler = lCrawler.next;
            rCrawler = rCrawler.next;
        }

        // If all nodes matched → palindrome
        return true;
    }
}