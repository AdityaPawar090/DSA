class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int ans = 0;
        int count = 0;

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                count++;
            }
            else {
                if(count != 0) {
                    count--;
                }
                else {
                    ans++;
                }
            }
        }
        ans += count;

        return ans;
    }
}