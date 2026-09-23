class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        getSubset(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public void getSubset(int[] nums, int index, List<Integer> ans, List<List<Integer>> result) {

        if(index == nums.length) {
            result.add(new ArrayList<>(ans));

            return;
        }

        ans.add(nums[index]);
        getSubset(nums, index + 1, ans, result);

        ans.remove(ans.size() - 1);

        getSubset(nums, index + 1, ans, result);
    }
}