class LRUCache {
    Map<Integer,Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new LinkedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        int ans=map.get(key);
        map.remove(key);
        map.put(key,ans);
        return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }

        if(map.size()==capacity){
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */