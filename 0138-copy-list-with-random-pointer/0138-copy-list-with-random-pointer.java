class Solution {
    public Node copyRandomList(Node head) {

        // Edge case: empty list
        if (head == null) {
            return null;
        }

        // Step 1: Create a mapping from original node → copied node
        // This helps us easily assign next and random pointers later
        Map<Node, Node> cpMap = new HashMap<>();

        Node curr = head;

        // First pass: create copy of each node (without linking)
        while (curr != null) {
            Node copy = new Node(curr.val); // create new node with same value
            cpMap.put(curr, copy);          // map original → copy
            curr = curr.next;
        }

        curr = head;

        // Step 2: Assign next and random pointers using map
        while (curr != null) {

            Node cp = cpMap.get(curr); // get copied node

            // Set next pointer of copied node
            cp.next = cpMap.get(curr.next); // null-safe (map returns null if key not found)

            // Set random pointer of copied node
            cp.random = cpMap.get(curr.random);

            curr = curr.next;
        }

        // Step 3: Return head of copied list
        return cpMap.get(head);
    }
}