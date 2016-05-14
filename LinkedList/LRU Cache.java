public class LRUCache {
    private int capacity;
    private int current;
    private ListNode head, tail;
    private HashMap<Integer, ListNode> map;
    
    public LRUCache(int _capacity) {
        capacity = _capacity;
        current = 0;
        map = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            updateNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            updateNode(node);
        }
        else {
            if (current < capacity) {
                ListNode node = new ListNode(key, value);
                map.put(key, node);
                updateNode(node);
                current++;
            }
            else {
                map.remove(tail.key);
                tail.val = value;
                tail.key = key;
                map.put(key, tail);
                updateNode(tail);
            }
        }
    }
    
    private void updateNode(ListNode node) {
        if (head == null) {
            head = tail = node;
            return;
        }
        if (head == node) return;
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (tail == node) tail = node.prev;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }
    
    private class ListNode {
        ListNode prev = null;
        ListNode next = null;
        int key, val;
        public ListNode(int k, int v) { key = k; val = v;}
    }
}
