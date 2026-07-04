class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            long ans = 1;
            for(int j=0; j<=i; j++) {
                row.add((int)ans);
                ans = ans * (i - j);
                ans = ans / (j + 1);
            }
            result.add(row);
        }
        return result;
    }
}