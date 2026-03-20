class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to simplify result list creation
        // Helps avoid handling head separately
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0; // To store carry from previous digit addition

        // Traverse both lists until all nodes and carry are processed
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry; // Start with carry

            // Add value from l1 if present
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next; // move pointer forward
            }

            // Add value from l2 if present
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next; // move pointer forward
            }

            // Calculate new carry
            carry = sum / 10;

            // Create new node with digit value (sum % 10)
            current.next = new ListNode(sum % 10);

            // Move result pointer forward
            current = current.next;
        }

        // Return result list (skip dummy node)
        return dummy.next;
    }
}