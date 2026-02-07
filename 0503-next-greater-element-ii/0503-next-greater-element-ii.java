class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        // Result array initialized with -1 (default if no NGE found)
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Stack stores indices of elements (not values)
        // Maintains decreasing order of values
        Stack<Integer> st = new Stack<>();

        // Traverse array twice to simulate circular behavior
        for (int i = 0; i < 2 * n; i++) {

            // Use modulo to wrap around the array
            int num = nums[i % n];

            // If current number is greater than stack top element,
            // then it is the Next Greater Element for that index
            while (!st.isEmpty() && num > nums[st.peek()]) {
                int index = st.pop();     // index waiting for NGE
                result[index] = num;      // assign NGE
            }

            // Only push indices from first pass
            // Second pass is only to resolve pending elements
            if (i < n) {
                st.push(i);
            }
        }

        return result;
    }
}
