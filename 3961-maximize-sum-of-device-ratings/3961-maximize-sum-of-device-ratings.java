class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int n = units[0].length;

        int[] min1 = new int[m];
        int[] min2 = new int[m];
        long total = 0;
        int one = -1;
        int two = -1;

        for(int i=0; i<m; i++) {
            int m1 = Integer.MAX_VALUE;
            int m2 = Integer.MAX_VALUE;

            for(int j=0; j<n; j++) {
                int val = units[i][j];
                if(val < m1) {
                    m2 = m1;
                    m1 = val;
                }
                else if(val < m2) {
                    m2 = val;
                }
            }
            if(n == 1) {
                m2 = 0;
            }

            min1[i] = m1;
            min2[i] = m2;
            total += Math.max(m1, m2);

            if(m2 > m1) {
                if(one == -1 || m1 < min1[one]) {
                    two = one;
                    one = i;
                }
                else if(two == -1 || m1 < min1[two]) {
                    two = i;
                }
            }
        }
        long maxSum = 0;


        for(int l=0; l<m; l++) {
            long newSum = total - Math.max(min1[l], min2[l]);
            int incoming = Integer.MAX_VALUE;
            if(one != -1 && one != l) {
                incoming = min1[one];
            }
            else if(two != -1 && two != l){
                incoming = min1[two];
            }
            int rating = Math.min(min1[l], incoming);
            newSum += rating;
            maxSum = Math.max(maxSum, newSum);
        }
        return maxSum;
    }
}