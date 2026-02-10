class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // Deque will store INDICES, not values
        // It will be maintained in DECREASING order of values
        // So nums[dq.peekFirst()] is always the maximum in the window
        Deque<Integer> dq = new ArrayDeque<>();

        // Result array for window maximums
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {

            // --------------------------------------------------
            // 1. Remove elements that are OUTSIDE the window
            // Window range = [i-k+1 ... i]
            // Any index <= i-k is outside
            // --------------------------------------------------
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // --------------------------------------------------
            // 2. Maintain DECREASING order in deque
            // Remove all smaller (or equal) elements from back
            // Because they can never become maximum again
            // Current element dominates them
            // --------------------------------------------------
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // --------------------------------------------------
            // 3. Add current index as a candidate for maximum
            // --------------------------------------------------
            dq.offerLast(i);

            // --------------------------------------------------
            // 4. Once first window of size k is formed
            // The FRONT of deque is always the max element
            // --------------------------------------------------
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
