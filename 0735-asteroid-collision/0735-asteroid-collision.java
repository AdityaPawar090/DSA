class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s1 = new Stack<>();
        
        for(int i=0; i<asteroids.length; i++) {
            int n1 = asteroids[i];
            boolean check = false;

            while(!s1.isEmpty() && s1.peek() > 0 && n1 < 0) {
                int top = s1.peek();

                if(top < Math.abs(n1)) {
                    s1.pop();
                }
                else if(top == Math.abs(n1)) {
                    s1.pop();
                    check = true;
                    break;
                }
                else {
                    check = true;
                    break;
                }
            }
            if(!check) {
                s1.push(n1);
            }
        }

        int result[] = new int[s1.size()];
        for(int i=0; i<s1.size(); i++) {
            result[i] = s1.get(i);
        }
        return result;
    }
}