class Solution {
    public int findJudge(int n, int[][] trust) {

        // trustData[i]:
        //   - decreases by 1 if i trusts someone
        //   - increases by 1 for every person that trusts i
        int[] trustData = new int[n + 1];

        // Process trust relationships
        for (int[] data : trust) {
            int a = data[0]; // a trusts
            int b = data[1]; // b is trusted

            trustData[a]--; // if a trusts someone, they cannot be judge
            trustData[b]++; // b gains trust from someone
        }

        // Judge must be:
        //  - trusted by everyone else: n - 1
        //  - trust nobody: contributes 0
        for (int i = 1; i <= n; i++) {
            if (trustData[i] == n - 1) {
                return i; // found judge
            }
        }

        // If no such person found
        return -1;
    }
}
