class Solution {
    public int countTriples(int n) {
        int count = 0;  // total valid (a, b, c) triples

        // Iterate over all possible values of a
        for (int a = 1; a <= n; a++) {

            // b starts from a+1 to avoid repeating pairs (a,b) and (b,a)
            for (int b = a + 1; b <= n; b++) {

                // Compute a² + b²
                int cSquare = a * a + b * b;

                // Calculate sqrt(a² + b²) → potential c
                int c = (int) Math.sqrt(cSquare);

                // Check if:
                // 1) c*c == a² + b² → c is a perfect square root (Pythagorean triple)
                // 2) c is within range 1..n
                if (c * c == cSquare && c <= n) {

                    // We found a valid triple (a, b, c)
                    // Since order matters: (a, b, c) and (b, a, c) are both valid
                    count += 2;
                }
            }
        }

        return count;  // return total count of valid triples
    }
}
