class LRUCache {

    private int capacity;
    private int size;
    private Map<Integer, PqNode> map = new HashMap<>();
    private Queue<PqNode> queue = new PriorityQueue<>(new PqNodeComparator());
    private long nextTime = 1;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(size == 0 || !map.containsKey(key))
            return -1;
        PqNode n = map.get(key);
        n.time = nextTime++;
        queue.remove(n);
        queue.add(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            PqNode m = map.get(key);
            map.remove(m.key);
            queue.remove(m);
            size--;
        }
        else if(size == capacity){
            //rem
            PqNode n = queue.poll();
            map.remove(n.key); 
            size--;
        }
        PqNode x = new PqNode(key, value, nextTime++);
        map.put(key, x);
        queue.add(x);
        size++;
    }

    private static class PqNode{
        public int key;
        public int val;
        public long time;
        
        public PqNode(int key, int val, long time){
            this.key = key;
            this.val = val;
            this.time = time;
        }
    }
    
    private static class PqNodeComparator implements Comparator<PqNode>{
        @Override
        public int compare(PqNode a, PqNode b){
            return (int)(a.time - b.time);
        }
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
