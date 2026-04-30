class Solution {

    // Generate subset sums grouped by count
    private void generate(int[] nums, int index, int count, int sum,
                          Map<Integer, List<Integer>> map) {

        if (index == nums.length) {
            map.computeIfAbsent(count, k -> new ArrayList<>()).add(sum);
            return;
        }

        // Pick element
        generate(nums, index + 1, count + 1, sum + nums[index], map);

        // Skip element
        generate(nums, index + 1, count, sum, map);
    }

    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, nums.length);

        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        Map<Integer, List<Integer>> rightMap = new HashMap<>();

        // Generate subset sums
        generate(left, 0, 0, 0, leftMap);
        generate(right, 0, 0, 0, rightMap);

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int target = totalSum / 2;
        int ans = Integer.MAX_VALUE;

        // Try all splits
        for (int k = 0; k <= n; k++) {

            List<Integer> list1 = leftMap.get(k);
            List<Integer> list2 = rightMap.get(n - k);

            Collections.sort(list2);

            for (int sum1 : list1) {

                int needed = target - sum1;

                int idx = Collections.binarySearch(list2, needed);

                if (idx < 0) idx = -idx - 1;

                // Check closest
                if (idx < list2.size()) {
                    int sum = sum1 + list2.get(idx);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum));
                }

                if (idx > 0) {
                    int sum = sum1 + list2.get(idx - 1);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum));
                }
            }
        }

        return ans;
    }
}