class Solution {
    public double myPow(double x, int n) {
        long N = n;              // avoid overflow for Integer.MIN_VALUE
        boolean neg = N < 0;
        if (neg) N = -N;

        double result = 1;
        double base = x;
        while (N > 0) {
            if ((N & 1) == 1) {
                result *= base;
            }
            base *= base;
            N >>= 1;
        }
        return neg ? 1 / result : result;
    }
}