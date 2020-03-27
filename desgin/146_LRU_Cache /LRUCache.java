class LRUCache {
    
    int size;
    Map<Integer,Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<Integer,Node>();
        head = new Node();
        head.prev = null;
        tail = new Node();
        tail.next = null;
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        removeNode(node);
        insertFrontNode(node);
        return node.val;
    }
    
    public void removeNode(Node node){
        // remove the current node  time compleity: O(1)
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void insertFrontNode(Node node){
        //head not changed
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            map.put(key, newNode);
            insertFrontNode(newNode);
            
            if(size<map.size()){
                Node lastNode = tail.prev;
                removeNode(lastNode);
                map.remove(lastNode.key);
            }
        }else{
            node.val = value;
            removeNode(node);
            insertFrontNode(node);
        }
    }
    
    class Node{
        int val;
        int key;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */