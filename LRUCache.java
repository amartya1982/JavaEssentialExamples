import java.util.HashMap;

class LRUCache<K, V> {
    private final int capacity;
    private final HashMap<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> dll;

    // Constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
    }

    // Get value from cache
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null; // Key not found
        }

        // Move the accessed node to the head of the list
        Node<K, V> node = map.get(key);
        dll.moveToHead(node);
        return node.value;
    }

    // Put key-value pair into the cache
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            // Update the value and move to the head
            Node<K, V> node = map.get(key);
            node.value = value;
            dll.moveToHead(node);
        } else {
            // Add a new key-value pair
            if (map.size() == capacity) {
                // Remove the least recently used node
                Node<K, V> tail = dll.removeTail();
                map.remove(tail.key);
            }

            // Create a new node and add it to the list and map
            Node<K, V> newNode = new Node<>(key, value);
            dll.addToHead(newNode);
            map.put(key, newNode);
        }
    }

    // Node class
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Doubly Linked List class
    private static class DoublyLinkedList<K, V> {
        private final Node<K, V> head, tail;

        DoublyLinkedList() {
            head = new Node<>(null, null); // Dummy head
            tail = new Node<>(null, null); // Dummy tail
            head.next = tail;
            tail.prev = head;
        }

        // Add node to the head of the list
        void addToHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Remove a node from the list
        void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Move an existing node to the head
        void moveToHead(Node<K, V> node) {
            removeNode(node);
            addToHead(node);
        }

        // Remove the tail node (least recently used)
        Node<K, V> removeTail() {
            Node<K, V> tailNode = tail.prev;
            removeNode(tailNode);
            return tailNode;
        }
    }

    // Main method to test LRUCache
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println(cache.get(1)); // Outputs: A
        cache.put(4, "D"); // Evicts key 2
        System.out.println(cache.get(2)); // Outputs: null
        cache.put(5, "E"); // Evicts key 3
        System.out.println(cache.get(3)); // Outputs: null
        System.out.println(cache.get(4)); // Outputs: D
        System.out.println(cache.get(5)); // Outputs: E
    }
}
