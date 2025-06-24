public class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
        this.prev=null;
        this.next=null;
    }
}
class LRUCache {
    int cap;
    HashMap<Integer,Node> cache;
    Node left;
    Node right;
    public LRUCache(int capacity) {
        this.cap=capacity;
        this.cache=new HashMap<>();
        this.left=new Node(0,0);
        this.right=new Node(0,0);
        this.left.next=this.right;
        this.right.prev=this.left;
    }
    public void remove(Node node){
        Node prev=node.prev;
        Node next=node.next;
        prev.next=next;
        next.prev=prev;
    }
    public void add(Node node){
        Node prev=this.right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=this.right;
        this.right.prev=node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode=new Node(key,value);
        cache.put(key,newNode);
        add(newNode);
        if(cache.size()>cap){
            Node lru=this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }

        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */