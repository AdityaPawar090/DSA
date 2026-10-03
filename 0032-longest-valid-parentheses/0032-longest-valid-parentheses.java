class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> s1 = new Stack<>();
        s1.push(-1);

        int ans = 0;

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(') {
                s1.push(i);
            }
            else {
                s1.pop();

                if(s1.isEmpty()) {
                    s1.push(i);
                }
                else {
                    ans = Math.max(ans, i - s1.peek());
                }
            }
        }
        return ans;
    }
}