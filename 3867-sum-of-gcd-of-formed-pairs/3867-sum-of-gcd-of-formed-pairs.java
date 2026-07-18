class Solution {

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        long ans = 0;
        List<Integer> prefixgcd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixgcd.add(gcd(nums[i], max));
        }
        Collections.sort(prefixgcd);

        for (int i = 0; i < n / 2; i++) {
            ans += gcd(prefixgcd.get(i), prefixgcd.get(n - 1 - i));
        }
        return ans;
    }
}