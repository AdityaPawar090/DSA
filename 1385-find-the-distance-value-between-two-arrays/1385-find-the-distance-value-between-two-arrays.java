class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int  count = 0;

        Arrays.sort(arr2);

        for(int i=0; i<n1; i++) {
            int left = 0;
            int right = n2 - 1;
            boolean found = false;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (Math.abs(arr1[i] - arr2[mid]) <= d) {
                    found = true;
                    break;
                }
                else if (arr2[mid] < arr1[i]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            if (!found) {
                count++;
            }
        }
        return count;
    }
}