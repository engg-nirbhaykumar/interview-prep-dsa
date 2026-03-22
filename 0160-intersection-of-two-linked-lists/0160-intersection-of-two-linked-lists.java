public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Edge case: if either list is empty, no intersection possible
        if (headA == null || headB == null) {
            return null;
        }

        // Initialize two pointers
        ListNode aCrawler = headA;
        ListNode bCrawler = headB;

        // Traverse both lists
        // When a pointer reaches end, redirect it to the other list's head
        while (aCrawler != bCrawler) {

            // If aCrawler reaches end → jump to headB
            // Else move forward
            aCrawler = (aCrawler == null) ? headB : aCrawler.next;

            // If bCrawler reaches end → jump to headA
            // Else move forward
            bCrawler = (bCrawler == null) ? headA : bCrawler.next;
        }

        // Either both meet at intersection node OR both become null (no intersection)
        return aCrawler;
    }
}