class LRUCache {

    LinkedHashMap<Integer, Integer> cache;
    int maxSize, size;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>();
        maxSize = capacity;
        size = 0;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //trying to add when overflowing
        if(size >= maxSize && !cache.containsKey(key)){
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
            cache.put(key, value);
        }
        //trying to update when max size
        else if(size >= maxSize){
            cache.remove(key);
            cache.put(key, value);
        }
        //trying to update
        else if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key, value);
        }
        else{
            cache.put(key, value);
            size++;
        }
    }
}

// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */
