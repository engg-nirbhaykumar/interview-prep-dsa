class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;

        // Sort array so smaller numbers come first
        // Helps because if nums[i] % nums[j] == 0,
        // then nums[j] can be predecessor of nums[i]
        Arrays.sort(nums);

        // dp[i] = size of largest divisible subset ending at i
        int[] dp = new int[n];

        // parent[i] = previous index used to build subset
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                // If divisible, nums[j] can come before nums[i]
                if (nums[i] % nums[j] == 0) {

                    // Better subset found
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }

            // Track maximum subset size
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct answer using parent array
        List<Integer> ans = new ArrayList<>();

        while (lastIndex != -1) {
            ans.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        // Reverse because reconstructed backwards
        Collections.reverse(ans);

        return ans;
    }
}