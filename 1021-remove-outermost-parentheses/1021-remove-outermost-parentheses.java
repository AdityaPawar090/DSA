class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (balance > 0) {
                    ans += s.charAt(i);
                }
                balance++;
            } else {
                balance--;
                if (balance > 0) {
                    ans += s.charAt(i);
                }
            }
        }
        return ans;
    }
}