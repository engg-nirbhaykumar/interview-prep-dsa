class LFUCache {

    // Maximum capacity of cache
    private int capacity;

    // Tracks the minimum frequency present in cache
    private int minFreq;

    // key -> value mapping (actual cache storage)
    private Map<Integer, Integer> keyToVal;

    // key -> frequency mapping (how many times key was used)
    private Map<Integer, Integer> keyToFreq;

    // freq -> keys with this frequency (LinkedHashSet maintains LRU order)
    private Map<Integer, LinkedHashSet<Integer>> freqToLRUKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToLRUKeys = new HashMap<>();
    }

    public int get(int key) {
        // If key doesn't exist → cache miss
        if (!keyToVal.containsKey(key))
            return -1;

        // Get current frequency of key
        final int freq = keyToFreq.get(key);

        // Remove key from its current frequency bucket
        freqToLRUKeys.get(freq).remove(key);

        // If this key was the only one in minFreq bucket → increase minFreq
        if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
            freqToLRUKeys.remove(freq);
            ++minFreq;
        }

        // Increase frequency of this key
        putFreq(key, freq + 1);

        // Return stored value
        return keyToVal.get(key);
    }

    public void put(int key, int value) {

        // Edge case: capacity 0 means cache can't store anything
        if (capacity == 0)
            return;

        // If key already exists → update value and treat as access
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key); // reuse get() to update frequency
            return;
        }

        // If cache is full → evict LFU key
        if (keyToVal.size() == capacity) {

            // Get LRU key from the lowest frequency bucket
            final int keyToEvict = freqToLRUKeys.get(minFreq).iterator().next();

            // Remove it from structures
            freqToLRUKeys.get(minFreq).remove(keyToEvict);
            keyToVal.remove(keyToEvict);
            keyToFreq.remove(keyToEvict);
        }

        // New key always starts with frequency = 1
        minFreq = 1;
        putFreq(key, minFreq);
        keyToVal.put(key, value);
    }

    // Helper: assign frequency to key and place it in correct bucket
    private void putFreq(int key, int freq) {

        // Update key → frequency mapping
        keyToFreq.put(key, freq);

        // Create bucket if it doesn't exist
        freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());

        // Add key to frequency bucket
        // LinkedHashSet keeps insertion order → helps remove LRU on tie
        freqToLRUKeys.get(freq).add(key);
    }
}
