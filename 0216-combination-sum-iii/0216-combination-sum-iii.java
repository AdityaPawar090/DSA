class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        generate(1, k, n, ans, new ArrayList<>());

        return ans;
    }

    public void generate(int ind, int k, int target,
                         List<List<Integer>> ans,
                         List<Integer> ds) {

        if (k == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        for (int i = ind; i <= 9; i++) {

            if (i > target) {
                break;
            }

            ds.add(i);

            generate(i + 1, k - 1, target - i, ans, ds);

            ds.remove(ds.size() - 1);
        }
    }
}