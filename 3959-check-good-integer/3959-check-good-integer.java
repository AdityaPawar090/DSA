class Solution {
    public boolean checkGoodInteger(int n) {
        int sum = 0;
        int squareSum = 0;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sum += digit;
            squareSum += (digit * digit);
        }

        if (squareSum - sum >= 50) {
            return true;
        }
        return false;
    }
}