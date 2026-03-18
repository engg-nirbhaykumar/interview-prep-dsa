class Solution {
    public ListNode middleNode(ListNode head) {

        // Step 1: Count total number of nodes in the linked list
        int count = 0;
        ListNode temp = head;

        // Traverse the list to calculate length
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Step 2: Find the middle index
        // For even length, this gives the second middle node (as required in LeetCode)
        int midIdx = count / 2;

        // Step 3: Traverse again to reach the middle node
        temp = head;
        for (int i = 0; i < midIdx; i++) {
            temp = temp.next;
        }

        // Step 4: Return the middle node
        return temp;
    }
}