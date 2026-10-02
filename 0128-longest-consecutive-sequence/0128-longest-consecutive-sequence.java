class Solution {
    public int longestConsecutive(int[] nums) {
         if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longest = 1;
        int n1 = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                n1++;
            }
            else if (nums[i] == nums[i - 1]) {
                continue;
            }
            else {
                n1 = 1;
            }
            
            longest = Math.max(longest, n1);
        }
        return longest;
    }
}