class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<Integer> s1 = new Stack<>();
        s1.push(0);

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                s1.push(0);
            }
            else {
                int top = s1.pop();

                int score = Math.max(2 * top, 1);

                s1.push(s1.pop() + score);
            }
        }
        int ans = s1.pop();

        return ans;
    }
}