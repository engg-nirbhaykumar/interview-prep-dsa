class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;

        // Create a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            rows[i] = new StringBuilder();

        int currRow = 0;
        boolean goingDown = false;

        // Simulate zigzag writing
        for (char ch : s.toCharArray()) {
            rows[currRow].append(ch);

            // Change direction at top or bottom
            if (currRow == 0 || currRow == numRows - 1)
                goingDown = !goingDown;

            currRow += goingDown ? 1 : -1;
        }

        // Merge all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows)
            result.append(row);

        return result.toString();
    }
}
