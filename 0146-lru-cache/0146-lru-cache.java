class LRUCache {

    // Doubly Linked List node
    class Node {
        int key, value;     // store both key and value
        Node prev, next;    // pointers for DLL

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;                 // max cache size
    private Map<Integer, Node> map;       // key → node lookup in O(1)
    private Node head, tail;              // dummy nodes (boundaries)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Create dummy head and tail to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // ------------------ GET ------------------
    public int get(int key) {

        // If key not present → cache miss
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        // Since this key is used now, move it to front (MRU)
        moveToFront(node);

        return node.value;
    }

    // ------------------ PUT ------------------
    public void put(int key, int value) {

        // Case 1: Key already exists → update + mark as recently used
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);

        } else {

            // Case 2: Cache full → remove Least Recently Used (LRU)
            if (map.size() == capacity) {
                Node lru = tail.prev;   // node before tail is LRU
                remove(lru);            // remove from DLL
                map.remove(lru.key);    // remove from map
            }

            // Insert new node at front (MRU position)
            Node newNode = new Node(key, value);
            addToFront(newNode);
            map.put(key, newNode);
        }
    }

    // ------------------ DLL OPERATIONS ------------------

    // Remove a node from its current position
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node right after head → Most Recently Used
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Move an existing node to front
    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }
}
