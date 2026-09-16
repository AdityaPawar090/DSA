class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;

        while (s.length() > index && s.charAt(index) == ' ') {
            index++;
        }

        if (s.length() > index && s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.length() > index && s.charAt(index) == '+') {
            index++;
        }

        return atoi(s, index, 0, sign);
    }

    public int atoi(String s, int index, long result, int sign) {
        if (index == s.length()) {
            return (int) (result * sign);
        }

        char ch = s.charAt(index);

        if (ch < '0' || ch > '9') {
            return (int) (result * sign);
        }

        int digit = ch - '0';

        result = result * 10 + digit;

        if (result > Integer.MAX_VALUE) {

            if (sign == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        return atoi(s, index + 1, result, sign);
    }
}