class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007; // To prevent overflow as per problem constraint

        // pse[i] = number of elements to the LEFT (including itself)
        // where arr[i] is the minimum
        int[] pse = new int[n];

        // nse[i] = number of elements to the RIGHT (including itself)
        // where arr[i] is the minimum
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        // ------------------ PREVIOUS SMALLER ELEMENT (PSE) ------------------
        // We maintain a MONOTONIC INCREASING stack
        // Pop all elements greater than current → they cannot be minimum
        for (int i = 0; i < n; i++) {

            // Remove elements strictly greater than arr[i]
            // This ensures we stop at previous element <= arr[i]
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            // If stack is empty → no smaller element on left
            // So arr[i] can extend all the way to index 0 → i+1 choices
            // Else → it can extend till index after previous smaller
            pse[i] = st.isEmpty() ? i + 1 : i - st.peek();

            st.push(i); // Push current index
        }

        st.clear(); // Reuse stack for next smaller

        // ------------------ NEXT SMALLER ELEMENT (NSE) ------------------
        // Traverse from right
        // Here we pop >= to handle duplicates correctly (avoid double count)
        for (int i = n - 1; i >= 0; i--) {

            // Remove elements greater OR equal to arr[i]
            // So next smaller must be strictly smaller
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            // If stack empty → no smaller element to right
            // So arr[i] can extend till end → n-i choices
            // Else → extend till before next smaller element
            nse[i] = st.isEmpty() ? n - i : st.peek() - i;

            st.push(i);
        }

        // ------------------ CONTRIBUTION CALCULATION ------------------
        long result = 0;

        for (int i = 0; i < n; i++) {

            // Number of subarrays where arr[i] is the minimum
            long contribution = (long) arr[i] * pse[i] * nse[i];

            // Each such subarray contributes arr[i]
            result = (result + contribution) % mod;
        }

        return (int) result;
    }
}
