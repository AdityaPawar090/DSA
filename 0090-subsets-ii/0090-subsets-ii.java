class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        getSubset(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public void getSubset(int[] nums, int index,
                           List<Integer> ans,
                           List<List<Integer>> result) {

        result.add(new ArrayList<>(ans));

        for (int i = index; i < nums.length; i++) {

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            ans.add(nums[i]);

            getSubset(nums, i + 1, ans, result);

            ans.remove(ans.size() - 1);
        }
    }
}