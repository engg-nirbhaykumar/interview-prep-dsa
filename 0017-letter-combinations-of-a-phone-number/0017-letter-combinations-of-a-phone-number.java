class Solution {

    // Stores all valid letter combinations
    private List<String> result;

    // Mapping of digit → possible letters (phone keypad)
    Map<Character, String> phoneMap;

    private void backTrack(String digits, StringBuilder temp, int index) {

        // Base case:
        // If we have processed all digits, one full combination is ready
        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }

        // Current digit we are processing
        char digit = digits.charAt(index);

        // Letters corresponding to this digit (like "abc" for '2')
        String possibleCh = phoneMap.get(digit);

        // Try all possible letters for this digit
        for (char ch : possibleCh.toCharArray()) {

            // Choose: add current letter
            temp.append(ch);

            // Explore: move to next digit
            backTrack(digits, temp, index + 1);

            //  Un-choose (Backtrack): remove last added letter
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        result = new ArrayList<>();
        phoneMap = new HashMap<>();

        // Edge case: empty input → no combinations
        if (digits.length() == 0)
            return result;

        // Phone keypad mapping
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        // Start backtracking from first digit
        backTrack(digits, new StringBuilder(), 0);

        return result;
    }
}
