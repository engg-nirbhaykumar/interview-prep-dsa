class Solution {

    public int countPrimes(int n) {

        // No prime numbers exist below 2
        if (n <= 2)
            return 0;

        // isPrime[i] will be true if i is prime
        boolean[] isPrime = new boolean[n];

        // Initially assume all numbers are prime
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime numbers
        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve of Eratosthenes
        // Iterate only till sqrt(n)
        for (int i = 2; i * i < n; i++) {

            // If i is still marked as prime
            if (isPrime[i]) {

                // Mark all multiples of i as non-prime
                // Start from i*i because smaller multiples
                // would have already been marked
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        // Count all prime numbers less than n
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
