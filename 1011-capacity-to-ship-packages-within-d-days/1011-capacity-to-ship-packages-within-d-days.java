class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            int requiredDays = 1;
            int weight = 0;

            for (int i = 0; i < weights.length; i++) {

                if (weight + weights[i] > mid) {
                    requiredDays++;
                    weight = 0;
                }

                weight += weights[i];
            }

            if (requiredDays <= days) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}