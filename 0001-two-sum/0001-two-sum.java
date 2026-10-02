class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> ans = new HashMap<>();

        for(int i=0; i<n; i++) {
            int needed = target - nums[i];

            if(ans.containsKey(needed)) {
                return new int[]{ans.get(needed), i};
            }

            ans.put(nums[i], i);
        } 
        return new int[]{};
    }
}