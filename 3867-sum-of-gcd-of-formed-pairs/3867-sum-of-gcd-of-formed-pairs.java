class Solution {
    public long gcdSum(int[] nums) {
         int n = nums.length;
        int[] arr = new int[n];

        int mx = 0;

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);

            int a = nums[i], b = mx;
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            arr[i] = a;
        }

        Arrays.sort(arr);

        long ans = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            int a = arr[l], b = arr[r];
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            ans += a;
            l++;
            r--;
        }

        return ans;
    }
}