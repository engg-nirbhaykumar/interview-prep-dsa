class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // g = greed factor of each child (minimum cookie size they need)
        // s = sizes of available cookies

        // Sort both arrays so we can try to satisfy the least greedy child first
        Arrays.sort(g);
        Arrays.sort(s);

        int n = g.length; // number of children
        int m = s.length; // number of cookies

        int i = 0; // pointer for children
        int j = 0; // pointer for cookies

        // Try to assign cookies to children
        while (i < n && j < m) {

            // If current cookie can satisfy current child
            if (s[j] >= g[i]) {
                // Child i is content, move to next child
                i++;
            }

            // Always move to next cookie (used or too small)
            j++;
        }

        // i represents number of children who got a cookie
        return i;
    }
}
