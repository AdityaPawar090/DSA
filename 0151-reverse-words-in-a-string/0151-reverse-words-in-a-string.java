class Solution {
    public String reverseWords(String s) {
        String words[] = s.trim().split("\\s+");
        String ans = "";
        int n = words.length;

        for(int i=n-1; i>=0; i--) {
            ans += words[i];

            if(i != 0) {
                ans += " ";
            }
        }
        return ans;
    }
}