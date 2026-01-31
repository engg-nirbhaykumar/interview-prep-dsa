class Solution {

    // Map to store frequency of each number
    private Map<Integer, Integer> freqMap;

    // Min-heap to keep only top k frequent elements
    // Heap stores Map.Entry<num, frequency>
    private PriorityQueue<Map.Entry<Integer, Integer>> minHeap;

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Build frequency map
        freqMap = new HashMap<>();
        for (int num : nums) {
            // Count occurrences of each number
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create min heap based on frequency
        // Smallest frequency stays on top
        minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        // Step 3: Maintain heap of size k
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {

            // Add current number-frequency pair
            minHeap.offer(entry);

            // If heap size exceeds k, remove least frequent element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Extract elements from heap into result array
        int[] result = new int[k];
        int index = 0;

        // Heap now contains k most frequent elements
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }

        return result;
    }
}
