class Solution {
    // dp for memoization
    int dp[][][];

    public int removeBoxes(int[] boxes) {

        int n = boxes.length;
        dp = new int[n + 1][n + 1][n + 1];
        return get(boxes, 0, boxes.length - 1, 0);

    }

    public int get(int[] boxes, int i, int j, int streak) {
        if (i > j)
            return 0;

        // first we traverse till the adjacent values are different

        while (i + 1 <= j && boxes[i] == boxes[i + 1]) {
            i++;
            streak++;
        }

        // memoization
        if (dp[i][j][streak] > 0)
            return dp[i][j][streak];

        // we calculate the ans here which is streak (length of similar elements) and move 
        // forward to the remaining block through recursion
        int ans = (streak + 1) * (streak + 1) + get(boxes, i + 1, j, 0);
        // also another way we can choose is to choose the inner elements first then the outer similar elements can be combined to get even 
        // larger value 
        for (int k = i + 1; k <= j; k++) {
            // we traverse from k (i has moved from 0 to just before the beginning of different elements) and keep searching for same value as
            // in i. after that the middle elements (between i+1 and k-1) are sent to differnt partition and from k to j(ending) we send the updated streak
            if (boxes[i] == boxes[k]) {
                ans = Math.max(ans, get(boxes, i + 1, k - 1, 0) + get(boxes, k, j, streak + 1));
            }
        }
        // return ans here 
        return dp[i][j][streak] = ans;

    }

}