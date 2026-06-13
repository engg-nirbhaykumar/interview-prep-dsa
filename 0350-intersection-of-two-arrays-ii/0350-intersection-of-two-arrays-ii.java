class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequencies in nums1
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Find common elements
        for (int num : nums2) {
            if (freq.getOrDefault(num, 0) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        // Convert List<Integer> to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}