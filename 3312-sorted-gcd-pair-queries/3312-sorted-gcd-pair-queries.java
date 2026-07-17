class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
       int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int[] freq = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        long[] divisible = new long[max + 1];

        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                divisible[i] += freq[j];
            }
        }

        long[] gcdCount = new long[max + 1];

        for (int i = max; i >= 1; i--) {
            long cnt = divisible[i];
            gcdCount[i] = cnt * (cnt - 1) / 2;

            for (int j = i * 2; j <= max; j += i) {
                gcdCount[i] -= gcdCount[j];
            }
        }

        long[] prefix = new long[max + 1];
        prefix[0] = 0;

        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + gcdCount[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;

            int low = 1;
            int high = max;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefix[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            ans[i] = low;
        }

        return ans; 
    }
}