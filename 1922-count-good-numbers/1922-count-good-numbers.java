class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        long x = 0;
        long y = 0;

        if (n % 2 == 0) {
            x = n / 2;
            y = n / 2;
        } else {
            x = (n / 2) + 1;
            y = n / 2;
        }

        long ans = pow(5, x);
        ans = (ans * pow(4, y)) % mod;

        return (int) ans;
    }

    public long pow(long x, long n) {
        long mod = 1000000007;

        if (n == 0) {
            return 1;
        }

        long result = pow(x, n / 2);

        result = (result * result) % mod;

        if (n % 2 != 0) {
            result = (result * x) % mod;
        }

        return result;
    }
}