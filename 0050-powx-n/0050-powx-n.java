class Solution {

    // Computes x raised to the power n (x^n)
    public double myPow(double x, int n) {

        // Convert n to long to safely handle Integer.MIN_VALUE
        long N = n;

        // If exponent is negative:
        // x^(-n) = (1/x)^n
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        // Use fast exponentiation
        return fastPow(x, N);
    }

    // Fast exponentiation using divide and conquer
    // Computes x^n in O(log n) time
    private double fastPow(double x, long n) {

        // Base case: x^0 = 1
        if (n == 0)
            return 1.0;

        // Recursively compute x^(n/2)
        double half = fastPow(x, n / 2);

        // If n is even: x^n = (x^(n/2))^2
        if (n % 2 == 0) {
            return half * half;
        }
        // If n is odd: x^n = (x^(n/2))^2 * x
        else {
            return half * half * x;
        }
    }
}
