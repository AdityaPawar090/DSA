class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long operations = (long) k1 + k2;
        int[] diff = new int[n];

        int maxDiff = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            total += diff[i];
        }

        if (operations >= total) {
            return 0;
        }

        int left = 0, right = maxDiff;

        while (left < right) {
            int mid = left + (right - left) / 2;

            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= operations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int target = left;
        long remaining = operations;
        long answer = 0;

        for (int d : diff) {
            if (d > target) {
                remaining -= d - target;
                answer += (long) target * target;
            } else {
                answer += (long) d * d;
            }
        }

        long count = 0;

        for (int d : diff) {
            if (d >= target && target > 0) {
                count++;
            }
        }

        long extra = Math.max(0, remaining);

        long reduceCount = Math.min(count, extra);

        answer -= reduceCount * (2L * target - 1);


        return answer;
    }
}