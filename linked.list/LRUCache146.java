package linked.list;

/*
146. LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
*/

public class LRUCache146 {

    private Map<Integer, Node> cache = new HashMap<>();
    private Node dummyHead = new Node(-1, -1);
    private Node dummyTail = new Node(-1, -1);
    private int capacity;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }
        if (cache.size() == capacity) {
            Node node = removeTail();
            cache.remove(node.key);
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        addToHead(node);
    }

    private void moveToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void addToHead(Node node) {
        dummyHead.next.prev = node;
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next = node;
    }

    private Node removeTail() {
        Node tail = dummyTail.prev;
        tail.prev.next = dummyTail;
        dummyTail.prev = tail.prev;
        return tail;
    }

    private static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

}
