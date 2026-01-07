class Solution {

    // Checks if we can place m balls such that
    // minimum distance between any two balls is at least 'mid'
    private boolean isPossible(int[] position, int m, int mid) {

        int count = 1; // first ball placed
        int lastPlaced = position[0]; // position of last placed ball

        for (int i = 1; i < position.length; i++) {

            // Place ball if distance constraint is satisfied
            if (position[i] - lastPlaced >= mid) {
                count++;
                lastPlaced = position[i];
            }

            // If we placed all m balls, condition is satisfied
            if (count == m) {
                return true;
            }
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {

        // Sort positions to apply greedy placement
        Arrays.sort(position);

        int low = 0;
        int high = position[position.length - 1] - position[0];
        int result = 0;

        // Binary search on the answer (minimum distance)
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if distance = mid is achievable
            if (isPossible(position, m, mid)) {
                result = mid; // valid answer
                low = mid + 1; // try larger distance
            } else {
                high = mid - 1; // reduce distance
            }
        }

        return result;
    }
}
