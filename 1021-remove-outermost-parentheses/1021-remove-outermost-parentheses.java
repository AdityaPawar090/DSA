class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder s1 = new StringBuilder();
        int depth = 0;

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(') {
                if(depth > 0) {
                    s1.append('(');
                }
                depth++;
            }
            else {
                depth--;
                if(depth > 0) {
                    s1.append(')');
                }
            }
        }
        String ans = s1.toString();

        return ans;
    }
}