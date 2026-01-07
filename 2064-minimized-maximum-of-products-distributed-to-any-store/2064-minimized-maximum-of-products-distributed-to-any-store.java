class Solution {

    // Checks whether it is possible to distribute all products
    // such that no store gets more than 'mid' products
    private boolean isPossible(int[] quantities, int n, int mid) {

        int storesNeeded = 0; // total stores required with max limit = mid

        // For each product type
        for (int q : quantities) {

            // Number of stores needed for this product type
            // ceil(q / mid)
            storesNeeded += (q + mid - 1) / mid;

            // If required stores exceed available stores, not possible
            if (storesNeeded > n)
                return false;
        }

        // Distribution is possible within n stores
        return storesNeeded <= n;
    }

    // Finds the maximum quantity among all product types
    // Used to define the upper bound of binary search
    private int getMax(int[] quantities) {
        int max = Integer.MAX_VALUE;
        for (int q : quantities) {
            max = Math.max(max, q);
        }
        return max;
    }

    public int minimizedMaximum(int n, int[] quantities) {

        // Minimum possible maximum products per store
        int low = 1;

        // Maximum possible maximum products per store
        int high = getMax(quantities);

        int result = high;

        // Binary search on the answer
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Check if max load = mid is feasible
            if (isPossible(quantities, n, mid)) {
                result = mid; // store valid answer
                high = mid - 1; // try to minimize maximum further
            } else {
                low = mid + 1; // increase allowed maximum
            }
        }

        // Minimum possible maximum products in any store
        return result;
    }
}
