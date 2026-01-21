class Solution {

    private static final int MOD = 1000000007;

    // Fast power with modulo
    private long findPow(long x, long n) {

        // Base case
        if (n == 0) return 1;

        // Recursive power
        long half = findPow(x, n / 2);

        // Apply modulo to avoid overflow
        half = (half * half) % MOD;

        // If exponent is odd, multiply once more by x
        if (n % 2 == 1) {
            half = (half * x) % MOD;
        }

        return half;
    }

    // LeetCode 1922 - Count Good Numbers
    public int countGoodNumbers(long n) {

        // Even positions can have 5 choices
        long even = (n + 1) / 2;

        // Odd positions can have 4 choices (prime digits)
        long prime = n / 2;

        // Compute result using fast power
        long result = (findPow(5, even) * findPow(4, prime)) % MOD;

        return (int) result;
    }
}
