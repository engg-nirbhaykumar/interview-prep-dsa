class Solution {
    public int findDuplicate(int[] nums) {

        // ----------------------------------------------------
        // Phase 1: Detect the cycle using Floyd’s Tortoise & Hare
        // ----------------------------------------------------
        // Treat nums[i] as a "pointer" to the next index.
        // Since one number is duplicated, it creates a cycle.
        int slow = nums[0]; // slow moves 1 step at a time
        int fast = nums[0]; // fast moves 2 steps at a time

        // Move slow and fast until they meet inside the cycle
        do {
            slow = nums[slow]; // slow → next
            fast = nums[nums[fast]]; // fast → next of next
        } while (slow != fast);

        // ----------------------------------------------------
        // Phase 2: Find the entrance of the cycle (duplicate number)
        // ----------------------------------------------------
        // Reset slow to the start.
        // Now slow and fast both move 1 step at a time.
        // The point where they meet again = duplicate number.
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow]; // move slow 1 step
            fast = nums[fast]; // move fast 1 step
        }

        // Both meet at the duplicate value
        return fast;
    }
}
