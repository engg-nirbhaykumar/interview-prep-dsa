public class Solution {

    public boolean hasCycle(ListNode head) {

        // Initialize two pointers:
        // slow -> moves 1 step at a time
        // fast -> moves 2 steps at a time
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {

            // Move slow by 1 step
            slow = slow.next;

            // Move fast by 2 steps
            fast = fast.next.next;

            // If slow and fast meet, cycle exists
            if (slow == fast)
                return true;
        }

        // If fast reaches null, no cycle exists
        return false;
    }
}