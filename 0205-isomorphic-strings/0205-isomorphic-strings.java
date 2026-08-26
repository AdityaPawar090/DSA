class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int mapst[] = new int[256];
        int mapts[] = new int[256];

        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(mapst[c1] != 0 && mapst[c1] != c2) {
                return false;
            }

            if(mapts[c2] != 0 && mapts[c2] != c1) {
                return false;
            }

            mapst[c1] = c2;
            mapts[c2] = c1;
        }
        return true;
    }
}