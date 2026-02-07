class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Map to store: element → its Next Greater Element
        Map<Integer, Integer> nge = new HashMap<>();

        // Monotonic decreasing stack
        // Stores elements for which we haven't found NGE yet
        Stack<Integer> st = new Stack<>();

        // Step 1: Process nums2 to build NGE map
        for (int num : nums2) {

            // If current number is greater than stack top,
            // then it is the NGE for the stack elements
            while (!st.isEmpty() && num > st.peek()) {
                int removed = st.pop(); // element waiting for NGE
                nge.put(removed, num); // map its NGE
            }

            // Push current number to stack
            // It might find its NGE later
            st.push(num);
        }

        // Remaining elements in stack have no NGE → treated as -1

        // Step 2: Build result for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {

            // If NGE exists in map, return it; else -1
            result[i] = nge.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
