class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int max = 0;
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(') {
                max++;
            }
            if(s.charAt(i) == ')') {
                max--;
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}