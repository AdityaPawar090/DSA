class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> s1 = new Stack<>();

        for(int i=0; i<2*n; i++) {
            int n1 = nums[i % n];

            while(!s1.isEmpty() && nums[s1.peek()] < n1) {
                result[s1.pop()] = n1;
            }

            if(i < n) {
                s1.push(i);
            }
        }
        return result;
    }
}