class Solution {
    public List<List<Integer>> generate(int numRows) {

        // This list will store all rows of Pascal's Triangle
        List<List<Integer>> result = new ArrayList<>();

        // Loop through each row index from 0 to numRows-1
        for (int i = 0; i < numRows; i++) {

            // Create a new row
            List<Integer> row = new ArrayList<>();

            // Every row always starts with 1
            row.add(1);

            // For rows after the first one, compute the inner values
            if (i > 0) {

                // Previous row from which we take values
                List<Integer> prevRow = result.get(i - 1);

                // Compute middle elements using Pascal's property:
                // element = prevRow[j-1] + prevRow[j]
                for (int j = 1; j < i; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }

                // Every row (except the first) ends with 1
                row.add(1);
            }

            // Add the fully built row to the result
            result.add(row);
        }

        return result;
    }
}
