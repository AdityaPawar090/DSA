class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count1 = 0;
        int count2 = 0;

        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            count1 += right - left + 1;
        }

        left = 0;
        sum = 0;

        if (goal > 0) {
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];

                while (sum > goal - 1) {
                    sum -= nums[left];
                    left++;
                }

                count2 += right - left + 1;
            }
        }

        return count1 - count2;
    }
}