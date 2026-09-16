class Solution {
    public double myPow(double x, int n) {
        long power = Math.abs((long) n);

        double result = pow(x, power);

        if (n < 0) {
            return 1 / result;
        }

        return result;
    }

    public double pow(double x, long n) {
        
        if(n == 0) {
            return 1;
        }

        double result = pow(x, n/2);

        if(n % 2 == 0) {
            return result * result;
        }

        return result * result * x;
    }
}