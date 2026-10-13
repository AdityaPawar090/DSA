class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long square[] = new long[n];
        long ans = 0;

        for(int i=0; i<n; i++) {
            square[i] = (long)nums[i] * nums[i];
        }

        Arrays.sort(square);

        for(int i=n/2; i<n; i++) {
            ans += square[i];
        }

        for(int i=0; i<n/2; i++) {
            ans -= square[i];
        }

        return ans;
    }
}