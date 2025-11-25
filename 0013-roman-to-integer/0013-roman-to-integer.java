class Solution {

    public int romanToInt(String s) {
        // Mapping of Roman symbols to their integer values
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            // Check if current value is less than the next one (e.g., IV = 4)
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans -= map.get(s.charAt(i)); // Subtract in such cases
            } else {
                ans += map.get(s.charAt(i)); // Otherwise just add normally
            }
        }

        return ans;
    }
}
