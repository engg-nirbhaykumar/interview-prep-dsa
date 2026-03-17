/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

        // We cannot access the previous node in this problem,
        // so we copy the value of the next node into the current node
        node.val = node.next.val;

        // Now skip the next node by pointing current node's next
        // to the node after the next node
        node.next = node.next.next;
    }
}