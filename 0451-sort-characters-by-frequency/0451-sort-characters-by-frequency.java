class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        HashMap<Character, Integer> h1 = new HashMap<>();

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            h1.put(ch, h1.getOrDefault(ch, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(h1.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        StringBuilder result = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : list) {

            char ch = entry.getKey();
            int frequency = entry.getValue();

            for(int i = 0; i < frequency; i++) {
                result.append(ch);
            }
        }
        String ans = result. toString();

        return ans;
    }
}