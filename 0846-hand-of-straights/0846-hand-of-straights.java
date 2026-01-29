class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        // If total cards can't be evenly divided into groups → impossible
        if (hand.length % groupSize != 0)
            return false;

        // Step 1: Count frequency of each card
        // We need to know how many times each number appears
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int h : hand) {
            freqMap.put(h, freqMap.getOrDefault(h, 0) + 1);
        }

        // Step 2: Min Heap of unique card values
        // Always start forming group from the smallest available card
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int key : freqMap.keySet()) {
            minHeap.offer(key);
        }

        // Step 3: Try to form groups until all cards are used
        while (!minHeap.isEmpty()) {

            // Smallest unused card → starting point of new group
            int start = minHeap.peek();

            // Try forming a consecutive sequence of size groupSize
            for (int i = 0; i < groupSize; i++) {
                int card = start + i;

                // If required consecutive card not present → fail
                if (!freqMap.containsKey(card))
                    return false;

                // Use one occurrence of the card
                freqMap.put(card, freqMap.get(card) - 1);

                // If count becomes zero, remove it completely
                if (freqMap.get(card) == 0) {
                    freqMap.remove(card);

                    // IMPORTANT:
                    // The card finishing must be the smallest available card.
                    // Otherwise order is broken and grouping is invalid.
                    if (minHeap.peek() != card)
                        return false;

                    // Remove it from heap as no copies remain
                    minHeap.poll();
                }
            }
        }

        // If all groups formed successfully
        return true;
    }
}
