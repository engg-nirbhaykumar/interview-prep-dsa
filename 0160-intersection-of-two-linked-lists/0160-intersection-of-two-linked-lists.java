public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Step 1: Store all nodes of list B in a HashSet
        // This allows O(1) lookup to check if a node exists in list B
        Set<ListNode> nodesInB = new HashSet<>();

        ListNode bCrawler = headB;
        while (bCrawler != null) {
            nodesInB.add(bCrawler); // store reference of each node
            bCrawler = bCrawler.next;
        }

        // Step 2: Traverse list A and check if any node exists in the set
        ListNode aCrawler = headA;
        while (aCrawler != null) {

            // If current node of A is present in set → intersection found
            if (nodesInB.contains(aCrawler))
                return aCrawler;

            aCrawler = aCrawler.next;
        }

        // Step 3: No intersection found
        return null;
    }
}