class Solution {

    // Function to find the node just before the middle
    private ListNode getMiddle(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 and fast by 2 (intended)
        while (fast != null && fast.next != null) {
            prev = slow; // track node before middle
            slow = slow.next; // move slow by 1
            fast = fast.next.next;
        }

        // Return node before middle to split list into two halves
        return (prev != null) ? prev : slow;
    }

    // Function to merge two sorted linked lists
    private ListNode mergeList(ListNode l1, ListNode l2) {

        // Dummy node to simplify merging
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Merge both lists in sorted order
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                curr.next = l1; // attach l1 node
                l1 = l1.next; // move l1 forward
            } else {
                curr.next = l2; // attach l2 node
                l2 = l2.next; // move l2 forward
            }

            curr = curr.next; // move result pointer
        }

        // Attach remaining nodes (if any)
        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next; // return merged list head
    }

    public ListNode sortList(ListNode head) {

        // Base case: list with 0 or 1 node is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split list into two halves
        ListNode mid = getMiddle(head);

        ListNode rightNode = mid.next; // start of second half
        mid.next = null; // break the list

        // Step 2: Recursively sort both halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(rightNode);

        // Step 3: Merge sorted halves
        return mergeList(l1, l2);
    }
}