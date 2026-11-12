class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int ans = 1;
        int count = 1;
        int count1 = 1;

        for (int i = 0; i < n - 1; i++) {

            if (nums[i] < nums[i + 1]) {
                count++;
                count1 = 1;
            }
            else if (nums[i] > nums[i + 1]) {
                count1++;
                count = 1;
            }
            else {
                count = 1;
                count1 = 1;
            }

            ans = Math.max(ans, Math.max(count, count1));
        }
        
        return ans;
    }
}