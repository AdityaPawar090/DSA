class Solution {
    public int finddays(int[] weights, int cap) {
        int n = weights.length;
        int days = 1;
        int load = 0;
        for(int i=0; i<n; i++) {
            if(weights[i] + load > cap) {
                days += 1;
                load = weights[i];
            }
            else {
                load += weights[i];
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0;
        int high = 0;
        for(int i=0; i<n; i++) {
            low = Math.max(low, weights[i]);
        }

        for(int i=0; i<n; i++) {
            high += weights[i];
        }

        while(low <= high) {
            int mid = (low + high) / 2;
            int noofdays = finddays(weights, mid);
            if(noofdays <= days) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}