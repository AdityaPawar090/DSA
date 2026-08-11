class Solution {

    public boolean canSplit(int[] nums, int k, int maxSum) {
        int subarray = 1;
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] > maxSum) return false;

            if(sum + nums[i] > maxSum) {
                subarray++;
                sum = nums[i];
                
                if(subarray > k) {
                    return false;
                }
            }
            else {
                sum += nums[i];
            }
        }
        return true;
    } 

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = nums[0];
        int high = nums[0];
        int ans = -1;
        for(int i=1; i<n; i++) {
            low = Math.min(low, nums[i]);
        }

        for(int i=1; i<n; i++) {
            high += nums[i];
        }

        while(low <= high) {
            int mid = (low + high) / 2;
            if(canSplit(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}