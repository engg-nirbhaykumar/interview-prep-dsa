class Solution {

    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;

        while (low <= high) {
            // Skip non-alphanumeric characters from the left
            while (low < high && !Character.isLetterOrDigit(s.charAt(low))) {
                low++;
            }

            // Skip non-alphanumeric characters from the right
            while (low < high && !Character.isLetterOrDigit(s.charAt(high))) {
                high--;
            }

            // Compare characters after converting to lowercase
            if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                return false;
            }

            low++;
            high--;
        }

        return true;
    }
}
