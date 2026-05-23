class Solution {

    public int maxEnvelopes(int[][] envelopes) {

        /*
         * Sort envelopes:
         * 1. Width in increasing order
         * 2. If width is same, height in decreasing order
         *
         * Why decreasing height?
         * Because envelopes with same width
         * cannot be nested.
         *
         * Example:
         * [5,4], [5,5]
         *
         * If sorted increasing by height,
         * LIS would incorrectly count both.
         */
        Arrays.sort(envelopes, (a, b) -> {

            if (a[0] == b[0])
                return b[1] - a[1];

            return a[0] - b[0];
        });

        /*
         * Now problem reduces to:
         * Find LIS on heights only.
         */

        int n = envelopes.length;

        // Stores LIS heights
        int[] lis = new int[n];

        int len = 0;

        for (int[] envelope : envelopes) {

            int height = envelope[1];

            /*
             * Find insertion position
             * using Binary Search
             */
            int left = 0;
            int right = len - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (lis[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            /*
             * Replace or extend LIS
             */
            lis[left] = height;

            // If added at end, increase length
            if (left == len)
                len++;
        }

        return len;
    }
}